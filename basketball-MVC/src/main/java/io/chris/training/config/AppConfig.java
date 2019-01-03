package io.chris.training.config;


import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import io.chris.training.service.jms.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;


@Configuration
@ComponentScan(basePackages = "io.chris.training",
        excludeFilters = @ComponentScan.Filter(type= FilterType.REGEX,pattern="io.ascending.training.api.*"))
public class AppConfig {

//    @Value("#{applicationProperties['amazon.s3.bucket']}")
    private String amazonS3Bucket="amazon.s3.bucket";

    @Autowired
    private Environment environment; // get jvm environment, get a string array
    private final Logger logger = LoggerFactory.getLogger(getClass());
    //private String propertyKey = "amazon.s3.bucket";

    @Bean(name="applicationProperties")
    public PropertiesFactoryBean getObProperties(){
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        String profile = environment.getActiveProfiles()[0];
        logger.debug("applicationProperties is"+ profile);
        bean.setLocation(new ClassPathResource("META-INF/env/application-"+profile+".properties"));
        return bean;
    }

    @Bean(name="shareProperties")
    public PropertiesFactoryBean getShareProperties(){
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("META-INF/share-runtime.properties"));
        return bean;
    }

    @Bean //approach 1: without service bean
    public StorageService getStorageServiceClass(@Autowired @Qualifier("applicationProperties") PropertiesFactoryBean propertiesFactoryBean) throws IOException {
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        StorageService storageService = new StorageService(s3Client);
        storageService.setBucket(propertiesFactoryBean.getObject().getProperty(amazonS3Bucket));
        return storageService;
    }

    @Bean // approach 2: autowired AmazonSQS
    @Profile({"dev","test","prod"})
    public AmazonSQS getAmazonSQS(){
        AmazonSQS sqsClient = AmazonSQSClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        return sqsClient;
    }




}

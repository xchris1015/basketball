package io.chris.training.mvc.config;


import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import io.chris.training.core.config.DataSourceConfig;
import io.chris.training.core.config.ServiceConfig;
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
@Import({DataSourceConfig.class, ServiceConfig.class})
@ComponentScan(basePackages = "io.chris.training.mvc",
        excludeFilters = @ComponentScan.Filter(type= FilterType.REGEX,pattern="io.ascending.training.mvc.api.*"))
public class AppConfig {


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


    @Bean // approach 2: autowired AmazonSQS
    @Profile({"dev","prod"})
    public AmazonSQS getAmazonSQS(){
        AmazonSQS sqsClient = AmazonSQSClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        return sqsClient;
    }




}

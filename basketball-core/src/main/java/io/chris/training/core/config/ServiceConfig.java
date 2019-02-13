package io.chris.training.core.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import io.chris.training.core.service.jms.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;


@ComponentScan(basePackages = "io.chris.training.core")
public class ServiceConfig {

    //    @Value("#{applicationProperties['amazon.s3.bucket']}")
    private String amazonS3Bucket="amazon.s3.bucket";

    @Bean
    //approach 1: without service bean. Here we might not need Autowired, it also work with current spring framework
    public StorageService getStorageServiceClass(@Autowired @Qualifier("applicationProperties") PropertiesFactoryBean propertiesFactoryBean) throws IOException {
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        StorageService storageService = new StorageService(s3Client);
        storageService.setBucket(propertiesFactoryBean.getObject().getProperty(amazonS3Bucket));
        return storageService;
    }
}

package io.chris.training.worker.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import io.chris.training.core.config.DataSourceConfig;
import io.chris.training.core.config.ServiceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

@Configuration
@Import({DataSourceConfig.class, ServiceConfig.class})
@ComponentScan(basePackages = "io.chris.training.worker")
public class WorkerConfig {


    @Autowired
    private Environment environment; // get jvm environment, get a string array
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Bean(name="applicationProperties")
    public PropertiesFactoryBean getObProperties(){
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        String profile = environment.getActiveProfiles()[0];
        logger.debug("applicationProperties is"+ profile);
        bean.setLocation(new ClassPathResource("META-INF/env/application-"+profile+".properties"));
        return bean;
    }



}

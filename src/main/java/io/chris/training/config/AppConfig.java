package io.chris.training.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;


@Configuration
@ComponentScan(basePackages = "io.chris.training")
public class AppConfig {

    @Autowired
    private Environment environment; // get jvm environment, get a string arrary
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



}

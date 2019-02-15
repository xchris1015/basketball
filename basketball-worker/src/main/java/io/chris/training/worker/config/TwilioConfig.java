package io.chris.training.worker.config;

import com.twilio.Twilio;
import io.chris.training.worker.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@ComponentScan(basePackages = "io.chris.training.worker")
public class TwilioConfig {


    public ProcessService getProcessService(@Autowired @Qualifier("applicationProperties") PropertiesFactoryBean propertiesFactoryBean) throws IOException {
        String ACCOUNT_SID = propertiesFactoryBean.getObject().getProperty("ACCOUNT_SID");
        String AUTH_TOKEN = propertiesFactoryBean.getObject().getProperty("AUTH_TOKEN");
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
        ProcessService processService = new ProcessService();
        return processService;
    }
}

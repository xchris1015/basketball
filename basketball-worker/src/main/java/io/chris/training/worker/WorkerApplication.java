package io.chris.training.worker;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkerApplication {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(WorkerApplication.class, args);
//        SQSMessageService messageService = app.getBean(SQSMessageService.class);
//        messageService.receiveMessage();
    }

    //useless code
//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            logger.debug("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                logger.debug(beanName);
//            }
//
//        };
//    }

}
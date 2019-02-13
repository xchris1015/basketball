package io.chris.training.worker.config;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

import javax.jms.Session;

@Configuration
@EnableJms
public class AmazonConfig {

    @Value("${aws.region}")
    private String region;

    @Bean(name="connectionFactory")
    public SQSConnectionFactory getSQSConnectionFactory(){
        AmazonSQS amazonSQS = AmazonSQSClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        SQSConnectionFactory factory = new SQSConnectionFactory(new ProviderConfiguration(),amazonSQS);
        return factory;
    }

    @Bean
    public JmsTemplate getJmsTemplate(@Autowired SQSConnectionFactory connectionFactory){
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        return jmsTemplate;
    }

    @Bean
    public DynamicDestinationResolver getTopicDynamicDestinationResolver(){return new DynamicDestinationResolver();}

    @Bean(name = "jmsListenerContainerFactory")
    @DependsOn("connectionFactory")
    public DefaultJmsListenerContainerFactory getDefaultJmsListenerContainerFactory(@Autowired SQSConnectionFactory sqsConnectionFactory,@Autowired DynamicDestinationResolver destinationResolver){
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setSessionTransacted(false);
        jmsListenerContainerFactory.setConnectionFactory(sqsConnectionFactory);
        jmsListenerContainerFactory.setDestinationResolver(destinationResolver);
        jmsListenerContainerFactory.setConcurrency("1");
        jmsListenerContainerFactory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
        return jmsListenerContainerFactory;
    }




    @Bean // approach 2: autowired AmazonSQS
    public AmazonSQS getAmazonSQS(){
        AmazonSQS sqsClient = AmazonSQSClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        return sqsClient;
    }

}

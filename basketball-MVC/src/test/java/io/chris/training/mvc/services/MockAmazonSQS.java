package io.chris.training.mvc.services;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.when;

@Configuration
public class MockAmazonSQS {
    private String queueUrl = "mockUrl";

    @Value("#{applicationProperties['jms.queue.name']}")
    protected String queue;

    @Bean
    @Profile("unit")
    public AmazonSQS getAmazonSQS() {
        AmazonSQS client= Mockito.mock(AmazonSQS.class);
        GetQueueUrlResult mockQueueResult = Mockito.mock(GetQueueUrlResult.class);
        Mockito.when(mockQueueResult.getQueueUrl()).thenReturn(queueUrl);
        Mockito.when(client.getQueueUrl(queue)).thenReturn(mockQueueResult);
        ReceiveMessageResult receiveMessage = Mockito.mock(ReceiveMessageResult.class);
        Mockito.when(client.receiveMessage(queueUrl)).thenReturn(receiveMessage);
        return client;
    }
}

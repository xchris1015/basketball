package io.chris.training.config;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.when;

@Configuration
public class MockAmazonSQS {
    //TODO is this a random url?
    private String queueUrl = "mockUrl";

    @Value("#{applicationProperties['jms.queue.name']}")
    protected String queue;

    @Bean
    @Profile("unit")
    public AmazonSQS getAmazonSQS() {
        AmazonSQS client= Mockito.mock(AmazonSQS.class);
        GetQueueUrlResult mockQueueResult = Mockito.mock(GetQueueUrlResult.class);
        when(mockQueueResult.getQueueUrl()).thenReturn(queueUrl);
        // TODO why return mockQueueResult in here?
        when(client.getQueueUrl(queue)).thenReturn(mockQueueResult);
        return client;
    }
}

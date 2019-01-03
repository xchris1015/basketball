package io.chris.training.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import io.chris.training.config.AppConfig;
import io.chris.training.service.jms.MessageService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
//@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;
    @Autowired
    private AmazonSQS client;

    @Value("#{applicationProperties['jms.queue.name']}") // approach 2, insert to method argument with variable
    private String queue;

    private String queueUrl = "mockUrl";

//    @Mock //make a fake instant
//    private AmazonSQS client = Mockito.mock(AmazonSQS.class);

    @Test
    public void sendMessageTest(){
        String messageBody = "Success!";
        int delaySec = 5;
        messageService.sendMessage(messageBody, delaySec);
        SendMessageRequest sendMsgRequest = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(messageBody)
                .withDelaySeconds(delaySec);
        verify(client,times(1)).sendMessage(sendMsgRequest);
    }

    @Test
    public void receiveMessageTest(){

 //       verify(client,times(1)).receiveMessage(queueUrl);
    }


//    public void receiveMessage(AmazonSQS sqs,String queue){
//        List<Message> messages = sqs.receiveMessage(queue).getMessages();
//    }



}

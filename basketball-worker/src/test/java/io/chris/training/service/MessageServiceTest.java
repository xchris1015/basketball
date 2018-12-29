package test.java.io.chris.training.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import io.chris.training.config.AppConfig;
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

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Value("#{applicationProperties['jms.queue.name']}") // approach 2, insert to method argument with variable

    private String queue="chrisbasketball-unit";

    private String queueUrl;

    @Mock //make a fake instant
    private AmazonSQS client = Mockito.mock(AmazonSQS.class);

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception{
        validateMockitoUsage();
    }

    @Test
    public void sendMessageTest(){
        String messageBody="message";
        Integer delaySecond = 5;
        messageService.sendMessage(messageBody,delaySecond);
///       SendMessageRequest messageRequest =
///       verify(client,times(1)).sendMessage(messageRequest);
    }

    @Test
    public void receiveMessageTest(){
        client.receiveMessage(queue).getMessages();
 //       verify(client,times(1)).receiveMessage(queueUrl);
    }


//    public void receiveMessage(AmazonSQS sqs,String queue){
//        List<Message> messages = sqs.receiveMessage(queue).getMessages();
//    }



}

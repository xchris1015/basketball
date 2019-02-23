package io.chris.training.mvc;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.MessageCreator;
import io.chris.training.mvc.config.MockAmazonSQS;
import io.chris.training.worker.config.WorkerConfig;
import io.chris.training.worker.service.ProcessService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import com.twilio.rest.api.v2010.account.Message;

import java.util.Map;

import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WorkerConfig.class, MockAmazonSQS.class})
@ActiveProfiles("unit")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class ProcessServiceTest {


    @Autowired
    private ProcessService processService;

    private MessageCreator message = Mockito.mock(MessageCreator.class);


    @Test
    public void SMSSendTest(){
        String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        String AUTH_TOKEN = "your_auth_token";
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
        processService.twillioSMSSend(message);
        verify(message,times(1)).create();
    }
}

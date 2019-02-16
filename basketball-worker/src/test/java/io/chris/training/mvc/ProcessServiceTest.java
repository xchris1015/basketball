package io.chris.training.mvc;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.MessageCreator;
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
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import com.twilio.rest.api.v2010.account.Message;

import java.util.Map;

import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
@ActiveProfiles("unit")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class ProcessServiceTest {

    @InjectMocks
    @Autowired
    private ProcessService processService;

    @Mock //make a fake instant
    private MessageCreator message = Mockito.mock(MessageCreator.class);

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception{
        validateMockitoUsage();
    }

    @Test
    public void SMSSendTest(){
        String ACCOUNT_SID = "XXXXX";
        String AUTH_TOKEN = "XXXXX";
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
        String receiveNumber = "+1234567890";
        String messageBody = "body";
        processService.SMSSend(receiveNumber,messageBody);
//        verify(message,times(1)).create()
    }
}

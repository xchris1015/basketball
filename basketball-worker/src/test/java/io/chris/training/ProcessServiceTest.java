package io.chris.training;

import io.chris.training.worker.service.ProcessService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ProcessServiceTest {

    @Autowired
    private ProcessService processService;

//    @Test
//    public void processMessageTest(){
//        String json = "{\"name\":\"mkyong\", \"age\":29}";
//
//    }
}

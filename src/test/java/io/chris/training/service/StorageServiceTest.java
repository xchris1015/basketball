package io.chris.training.service;


import com.amazonaws.services.s3.AmazonS3;
import io.chris.training.config.AppConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.validateMockitoUsage;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class StorageServiceTest{

    @InjectMocks
    @Autowired
    private StorageService storageService;

    @Value("#{applicationProperties['amazon.s3.bucket']}")
    protected String s3Bucket;

    @Mock //make a fake instant
    private AmazonS3 client = Mockito.mock(AmazonS3.class);

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception{
        validateMockitoUsage();
    }

    @Test
    public void putObjectTest(){
        String s3Key="hhhh";
        File file = new File("~/Desktop/1.png");
        String bucket= "chrisbasketball";
        storageService.putObject(s3Key,file);
        assertTrue(false);

    }

    @Test
    public void putObjectMockTest(){


    }

    @Test
    public void getObjectMockTest(){


    }



}

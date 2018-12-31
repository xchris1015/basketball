package io.chris.training.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import io.chris.training.config.AppConfig;
import org.apache.commons.io.FilenameUtils;
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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;

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
        File file = new File("/Users/chris/Desktop/1.png");
        storageService.putObject("test1.png",file);
        assertTrue(false);
    }

    @Test
    public void putObjectMockTest(){
        String key = "testkey";
        File file = new File("/Users/chris/Desktop/1.png");
        storageService.putObject(key,file);
        verify(client,times(1)).putObject(s3Bucket,key,file);

        String key2 = "";
        File file2 = new File("/Users/chris/Desktop/1.png");
        storageService.putObject(key2,file2);
        verify(client,times(1)).putObject(s3Bucket,key2,file2);
    }

    @Test
    public void getObjectMockTest(){
        String key = "testkey";
        storageService.getObject(key);
        verify(client,times(1)).getObject(s3Bucket,key);
    }

    @Test
    public void convertFileTest(){
//        Path path = Paths.get("/Desktop/1.png");
//        String name = "file.png";
//        String originalFileName = "file.png";
//        String contentType = FilenameUtils.getExtension(name);
//        byte[] content = null;
//        try {
//            content = Files.readAllBytes(path);
//        } catch (final IOException e) {
//        }
//        MultipartFile result = new CommonsMultipartFile();
//
//
//
//
//        String key = "testkey";
//        File file = new File("/Users/chris/Desktop/1.png");
//        storageService.putObject(key,file);



    }



}

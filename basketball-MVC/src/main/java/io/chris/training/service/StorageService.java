package io.chris.training.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


public class StorageService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private  AmazonS3 s3;
    private String bucket;
    @Value("#{applicationProperties['amazon.s3.url']}")
    private String cdnUrl;

    public StorageService(AmazonS3 s3){
        this.s3=s3;
    }

    public StorageService(){ }

    public AmazonS3 getS3() {
        return s3;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public void putObject(String S3key, File file){
        s3.putObject(bucket,S3key,file);
    }

    public void putObject(String bucket, String S3key, File file){
        s3.putObject(bucket,S3key,file);
    }

    public S3Object getObject(String S3key){
        return s3.getObject(bucket,S3key);
    }

    // TODO relative path, put convert file to Services
    // TODO 1 Service Mutifile to file. 2 StorageService fileName already to UUID.extension then upload to S3.
    // TODO 3 S3 Object have S3 Key with new Image setting up on the ImageServices

    public File convertFile(MultipartFile file){
        String fileName = file.getOriginalFilename();
        logger.info("This file name is:"+ fileName);

        String systemRoot = System.getProperty("user.home");

        File convertedFile = new File( systemRoot+file.getOriginalFilename());
        try{
            file.transferTo(convertedFile);
        }catch (IOException e){
            logger.debug("cannot save file," +e);
        }
        return convertedFile;
    }

}

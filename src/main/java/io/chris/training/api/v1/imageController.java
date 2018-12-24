package io.chris.training.api.v1;

import io.chris.training.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/image")
public class imageController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public StorageService storageService;

    @RequestMapping(method = RequestMethod.POST)
    public void uploadImage(@RequestParam(value = "image") MultipartFile file){
        String fileName = file.getOriginalFilename();
        logger.info("This file name is:"+ fileName);

        //TODO
        File convertedFile = new File( "/Users/Chris/Downloads/"+file.getOriginalFilename());
        try{
            file.transferTo(convertedFile);
        }catch (IOException e){
            logger.debug("cannot save file," +e);
        }
        storageService.putObject("filename",convertedFile);
    }





}

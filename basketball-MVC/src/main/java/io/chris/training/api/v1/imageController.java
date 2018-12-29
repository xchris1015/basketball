package io.chris.training.api.v1;

import com.amazonaws.services.s3.model.S3Object;
import io.chris.training.domain.Image;
import io.chris.training.service.ImageService;
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
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/image")
public class imageController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public StorageService storageService;

    @Autowired
    public ImageService imageService;

    @RequestMapping(method = RequestMethod.POST)
    public void uploadImage(@RequestParam(value = "image") MultipartFile file){
        File convertedFile = storageService.convertFile(file);
        String uuid = UUID.randomUUID().toString();
        storageService.putObject(uuid,convertedFile);
        S3Object s3Object = storageService.getObject(uuid);
        Image image = new Image();
        image.setUuid(s3Object.getKey());
        imageService.addImage(image);
    }





}

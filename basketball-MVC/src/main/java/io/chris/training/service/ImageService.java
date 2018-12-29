package io.chris.training.service;

import io.chris.training.domain.Image;
import io.chris.training.repository.ImageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public List<Image> findAll(){
        List<Image> result = imageRepository.findAll();
        return result;
    }

    public Image findByUUID(String UUID){
        logger.debug("this UUID is:" + UUID);
        Image result = imageRepository.findByUuid(UUID);
        return result;
    }

    public Image addImage(Image image){
        Image result = imageRepository.save(image);
        return result;
    }


}

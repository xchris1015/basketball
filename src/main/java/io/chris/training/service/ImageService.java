package io.chris.training.service;

import io.chris.training.domain.Image;
import io.chris.training.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<Image> findAll(){
        List<Image> result = imageRepository.findAll();
        return result;
    }

    public Image findByUUID(String UUID){
        Image result = imageRepository.findByUUID(UUID);
        return result;
    }

    public Image findByFileName(String fileName){
        Image result = imageRepository.findByFileName(fileName);
        return result;
    }

}

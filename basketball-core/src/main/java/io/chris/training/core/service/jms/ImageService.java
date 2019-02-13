package io.chris.training.core.service.jms;

import io.chris.training.core.domain.Image;
import io.chris.training.core.repository.ImageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Image findByUUID(String uuid){
        logger.debug("this UUID is:" + uuid);
        Image result = imageRepository.findByUuid(uuid);
        return result;
    }

    public Image addImage(Image image){
        Image result = imageRepository.save(image);
        return result;
    }


}

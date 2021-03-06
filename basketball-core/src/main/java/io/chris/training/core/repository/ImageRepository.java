package io.chris.training.core.repository;

import io.chris.training.core.domain.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image,Long> {
    //TODO two query one with image and one without;
    List<Image> findAll();
    Image findByUuid(String uuid);

}

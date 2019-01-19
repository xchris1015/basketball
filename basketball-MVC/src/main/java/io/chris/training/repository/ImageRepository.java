package io.chris.training.repository;

import io.chris.training.domain.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ImageRepository extends CrudRepository<Image,Long> {
    //TODO two query one with image and one without;
    List<Image> findAll();
    Image findByUuid(String uuid);

}

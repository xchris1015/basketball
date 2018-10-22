package io.chris.training.repository;

import io.chris.training.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User>findByUsername(String username);

    List<User> findByFirstName(String firstName);

    List<User>findByLastName(String lastName);

    Optional<User>findByEmail(String email);

    List<User> findAll();






}

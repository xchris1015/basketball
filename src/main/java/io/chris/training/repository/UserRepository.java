package io.chris.training.repository;

import io.chris.training.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User>findByUsername(String username);

    Optional<User>findByFirstName(String firstName);

    Optional<User>findByLastName(String lastName);

    Optional<User>findByEmail(String email);

    Optional<User>findByPasswords(String passwords);

    Optional<User> findById(Long id);






}

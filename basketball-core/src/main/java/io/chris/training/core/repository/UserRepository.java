package io.chris.training.mvc.core.repository;

import io.chris.training.mvc.core.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.time.Instant;
import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);

    List<User> findByFirstName(String firstName);

    List<User>findByLastName(String lastName);

    List<User>findByCreateAt(Instant createAt);

    User findByEmail(String email);

    List<User> findAll();



}

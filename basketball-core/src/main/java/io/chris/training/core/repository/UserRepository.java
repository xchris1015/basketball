package io.chris.training.core.repository;

import io.chris.training.core.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.time.Instant;
import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsernameIgnoreCase(String username);

    List<User> findByFirstNameIgnoreCase(String firstName);

    List<User>findByLastNameIgnoreCase(String lastName);

    List<User>findByCreateAt(Instant createAt);

    User findByEmailIgnoreCase(String email);

    List<User> findAll();

}

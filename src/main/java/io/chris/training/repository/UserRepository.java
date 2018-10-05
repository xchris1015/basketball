package io.chris.training.repository;

import io.chris.training.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsernameIgnoreCase(String username);

}

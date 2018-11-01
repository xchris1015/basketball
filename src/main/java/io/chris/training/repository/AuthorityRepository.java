package io.chris.training.repository;

import io.chris.training.domain.Authority;
import io.chris.training.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorityRepository extends CrudRepository<Authority,Long> {

    List<Authority> findAuthoritiesByUser(User user);

}

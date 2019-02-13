package io.chris.training.core.repository;

import io.chris.training.core.domain.Authority;
import io.chris.training.core.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorityRepository extends CrudRepository<Authority,Long> {

    List<Authority> findAuthoritiesByUser(User user);
}

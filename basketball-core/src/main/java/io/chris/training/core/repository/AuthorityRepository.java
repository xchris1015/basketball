package io.chris.training.mvc.core.repository;

import io.chris.training.mvc.core.domain.Authority;
import io.chris.training.mvc.core.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorityRepository extends CrudRepository<Authority,Long> {

    List<Authority> findAuthoritiesByUser(User user);
}

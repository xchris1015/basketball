package io.chris.training.repository;

import io.chris.training.domain.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayersRepository extends CrudRepository<Player,Long> {

    Optional<Player> findByFirstName(String firstName);
}

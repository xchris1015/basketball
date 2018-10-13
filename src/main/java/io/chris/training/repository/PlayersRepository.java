package io.chris.training.repository;

import io.chris.training.domain.Player;
import org.springframework.data.repository.CrudRepository;

import java.time.Instant;
import java.util.Optional;

public interface PlayersRepository extends CrudRepository<Player,Long> {

    Optional<Player> findByFirstName(String firstName);
    Optional<Player> findByLastName(String lastName);
    Optional<Player> findByPlayerPosition(String playerPosition);
    Optional<Player> findByBorn(Instant born);
    Optional<Player> findByHeight(Double height);
    Optional<Player> findByWeight(Double weight);

}

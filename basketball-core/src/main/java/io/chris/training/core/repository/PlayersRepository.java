package io.chris.training.core.repository;

import io.chris.training.core.domain.Player;
import org.springframework.data.repository.CrudRepository;

import java.time.Instant;
import java.util.List;

public interface PlayersRepository extends CrudRepository<Player,Long> {

    List<Player> findByFirstName(String firstName);
    List<Player> findByLastName(String lastName);
    List<Player> findByPlayerPosition(String playerPosition);
    List<Player> findByBorn(Instant born);
    List<Player> findByHeight(Double height);
    List<Player> findByWeight(Double weight);
    List<Player> findAll();

}

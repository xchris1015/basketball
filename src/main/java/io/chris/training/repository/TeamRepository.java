package io.chris.training.repository;


import io.chris.training.domain.Team;
import io.chris.training.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team,Long> {

    List<Team> findByConference(String conference);
    List<Team> findByDivision(String division);
    List<Team> findByFoundYear(Instant foundYear);
    List<Team> findAll();
    Optional<Team> findByHistory(String history);
    Optional<Team> findByArena(String arena);
    Optional<Team> findByLocation(String location);

}

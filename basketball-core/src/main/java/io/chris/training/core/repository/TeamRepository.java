package io.chris.training.core.repository;


import io.chris.training.core.domain.Team;
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

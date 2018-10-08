package io.chris.training.repository;


import io.chris.training.domain.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team,Long> {

    Optional<Team> findByConference(String conference);
    Optional<Team> findByDivision(String division);
    Optional<Team> findByFoundYear(String foundYear);
    Optional<Team> findByHistory(String history);
    Optional<Team> findByArena(String arena);
    Optional<Team> findByLocation(String location);

}

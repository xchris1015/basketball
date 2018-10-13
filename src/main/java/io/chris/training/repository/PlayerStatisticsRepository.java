package io.chris.training.repository;

import io.chris.training.domain.PlayerStatistics;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayerStatisticsRepository extends CrudRepository<PlayerStatistics,Long> {

    Optional<PlayerStatistics> findByScore(Double score);
    Optional<PlayerStatistics> findByRebound(Double rebound);
    Optional<PlayerStatistics> findByAssistant(Double assistant);
    Optional<PlayerStatistics> findBySteal(Double steal);



}

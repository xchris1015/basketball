package io.chris.training.repository;

import io.chris.training.domain.PlayerStatistics;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerStatisticsRepository extends CrudRepository<PlayerStatistics,Long> {

    List<PlayerStatistics> findByScore(Double score);
    List<PlayerStatistics> findByRebound(Double rebound);
    List<PlayerStatistics> findByAssistant(Double assistant);
    List<PlayerStatistics> findBySteal(Double steal);
    List<PlayerStatistics> findAll();



}

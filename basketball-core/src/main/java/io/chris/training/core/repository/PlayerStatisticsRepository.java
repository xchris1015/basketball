package io.chris.training.mvc.core.repository;

import io.chris.training.mvc.core.domain.PlayerStatistics;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerStatisticsRepository extends CrudRepository<PlayerStatistics,Long> {

    List<PlayerStatistics> findByScore(Double score);
    List<PlayerStatistics> findByRebound(Double rebound);
    List<PlayerStatistics> findByAssistant(Double assistant);
    List<PlayerStatistics> findBySteal(Double steal);
    List<PlayerStatistics> findAll();



}

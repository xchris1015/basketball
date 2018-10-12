package io.chris.training.service;

import io.chris.training.domain.PlayerStatistics;
import io.chris.training.repository.PlayerStatisticsRepository;
import io.chris.training.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerStatisticsService {

    @Autowired
    private PlayerStatisticsRepository playerStatisticsRepository;

    public PlayerStatistics findById(Long id){

        Optional<PlayerStatistics> result = playerStatisticsRepository.findById(id);
        PlayerStatistics obj = result.get();
        return obj;

    }


    public PlayerStatistics findByScore(Double score){
        Optional<PlayerStatistics> result = playerStatisticsRepository.findByScore(score);
        PlayerStatistics obj = result.get();
        return obj;
    }

    public PlayerStatistics findByRebound(Double rebound){
        Optional<PlayerStatistics> result = playerStatisticsRepository.findByRebound(rebound);
        PlayerStatistics obj = result.get();
        return obj;
    }

    public PlayerStatistics findByAssistant(Double assistant){
        Optional<PlayerStatistics> result = playerStatisticsRepository.findByAssistant(assistant);
        PlayerStatistics obj = result.get();
        return obj;
    }

    public PlayerStatistics findBySteal(Double steal){
        Optional<PlayerStatistics> result = playerStatisticsRepository.findBySteal(steal);
        PlayerStatistics obj = result.get();
        return obj;
    }


}

package io.chris.training.mvc.core.service;

import io.chris.training.mvc.core.domain.PlayerStatistics;
import io.chris.training.mvc.core.repository.PlayerStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<PlayerStatistics> findAll(){
        List<PlayerStatistics> result = playerStatisticsRepository.findAll();
        return result;
    }


    public List<PlayerStatistics> findByScore(Double score){
        List<PlayerStatistics> result = playerStatisticsRepository.findByScore(score);
        return result;
    }

    public List<PlayerStatistics> findByRebound(Double rebound){
        List<PlayerStatistics> result = playerStatisticsRepository.findByRebound(rebound);
        return result;
    }

    public List<PlayerStatistics> findByAssistant(Double assistant){
        List<PlayerStatistics> result = playerStatisticsRepository.findByAssistant(assistant);
        return result;
    }

    public List<PlayerStatistics> findBySteal(Double steal){
        List<PlayerStatistics> result = playerStatisticsRepository.findBySteal(steal);
        return result;
    }

    public PlayerStatistics addPlayerStatistics(PlayerStatistics playerStatistics){
        PlayerStatistics result = playerStatisticsRepository.save(playerStatistics);
        return result;
    }


}

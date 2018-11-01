package io.chris.training.service;

import io.chris.training.config.AppConfig;
import io.chris.training.domain.PlayerStatistics;
import io.chris.training.repository.PlayerStatisticsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class PlayerStatisticsServiceTest {

    @Autowired
    private PlayerStatisticsRepository playerStatisticsRepository;

    @Autowired
    private PlayerStatisticsService playerStatisticsService;

    @Test
    @Transactional
    public void findByIdTest(){
        PlayerStatistics expectedPlayer = new PlayerStatistics();
        expectedPlayer.setAssistant(3.0);
        expectedPlayer.setRebound(7.0);
        expectedPlayer.setScore(12.5);
        playerStatisticsRepository.save(expectedPlayer);
        PlayerStatistics actualPlayer = playerStatisticsService.findById(expectedPlayer.getId());
        assertEquals(actualPlayer.getId(),expectedPlayer.getId());
    }

    @Test
    @Transactional
    public void findByScoreTest(){
        PlayerStatistics expectedPlayer = new PlayerStatistics();
        expectedPlayer.setAssistant(3.0);
        expectedPlayer.setRebound(7.0);
        expectedPlayer.setScore(12.5);
        playerStatisticsRepository.save(expectedPlayer);
        List<PlayerStatistics> actualPlayer = playerStatisticsService.findByScore(12.5);
        assertTrue(actualPlayer.size()>0);
    }

    @Test
    @Transactional
    public void findByReboundTest(){
        PlayerStatistics expectedPlayer = new PlayerStatistics();
        expectedPlayer.setAssistant(3.0);
        expectedPlayer.setRebound(7.0);
        expectedPlayer.setScore(12.5);
        playerStatisticsRepository.save(expectedPlayer);
        List<PlayerStatistics> actualPlayer = playerStatisticsService.findByRebound(7.0);
        assertTrue(actualPlayer.size()>0);
    }

    @Test
    @Transactional
    public void findByAssistantTest(){
        PlayerStatistics expectedPlayer = new PlayerStatistics();
        expectedPlayer.setAssistant(3.0);
        expectedPlayer.setRebound(7.0);
        expectedPlayer.setScore(12.5);
        playerStatisticsRepository.save(expectedPlayer);
        List<PlayerStatistics> actualPlayer = playerStatisticsService.findByAssistant(3.0);
        assertTrue(actualPlayer.size()>0);
    }

    @Test
    @Transactional
    public void findByStealTest(){
        PlayerStatistics expectedPlayer = new PlayerStatistics();
        expectedPlayer.setAssistant(3.0);
        expectedPlayer.setRebound(7.0);
        expectedPlayer.setScore(12.5);
        expectedPlayer.setSteal(1.2);
        playerStatisticsRepository.save(expectedPlayer);
        List<PlayerStatistics> actualPlayer = playerStatisticsService.findBySteal(1.2);
        assertTrue(actualPlayer.size()>0);
    }





}

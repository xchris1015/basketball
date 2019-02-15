//package io.chris.training.core.service;
//
//import io.chris.training.config.AppConfig;
//import io.chris.training.domain.Team;
//import io.chris.training.repository.TeamRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.Instant;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//@WebAppConfiguration
//@ContextConfiguration(classes = {AppConfig.class})
//@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles("unit")
//public class TeamServiceTest {
//
//    @Autowired
//    private TeamRepository teamRepository;
//
//    @Autowired
//    private TeamService teamService;
//
//    private LocalDate date = LocalDate.parse("2018-10-10");
//
//    @Test
//    @Transactional
//    public void findByIdTest(){
//        Team expectTeam = new Team();
//        expectTeam.setArena("Highland Park");
//        expectTeam.setConference("GWU");
//        expectTeam.setDivision("Graduate");
//        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
//        expectTeam.setFoundYear(instant);
//        expectTeam.setLocation("Highland Park");
//        expectTeam.setHistory("No History");
//        teamRepository.save(expectTeam);
//        Team actualTeam = teamService.findById(expectTeam.getId());
//        assertEquals(expectTeam.getId(),actualTeam.getId());
//    }
//
//    @Test
//    @Transactional
//    public void findByConferenceTest(){
//        Team expectTeam = new Team();
//        expectTeam.setArena("Highland Park");
//        expectTeam.setConference("GWU");
//        expectTeam.setDivision("Graduate");
//        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
//        expectTeam.setFoundYear(instant);
//        expectTeam.setLocation("Highland Park");
//        expectTeam.setHistory("No History");
//        teamRepository.save(expectTeam);
//        List<Team> actualTeam = teamService.findByConference("GWU");
//        assertTrue(actualTeam.size()>0);
//    }
//
//    @Test
//    @Transactional
//    public void findByDivisionTest(){
//        Team expectTeam = new Team();
//        expectTeam.setArena("Highland Park");
//        expectTeam.setConference("GWU");
//        expectTeam.setDivision("Graduate");
//        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
//        expectTeam.setFoundYear(instant);
//        expectTeam.setLocation("Highland Park");
//        expectTeam.setHistory("No History");
//        teamRepository.save(expectTeam);
//        List<Team> actualTeam = teamService.findByDivision("Graduate");
//        assertTrue(actualTeam.size()>0);
//    }
//
//    @Test
//    @Transactional
//    public void findByArenaTest(){
//        Team expectTeam = new Team();
//        expectTeam.setArena("Highland Park");
//        expectTeam.setConference("GWU");
//        expectTeam.setDivision("Graduate");
//        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
//        expectTeam.setFoundYear(instant);
//        expectTeam.setLocation("Highland Park");
//        expectTeam.setHistory("No History");
//        teamRepository.save(expectTeam);
//        Team actualTeam = teamService.findByArena("Highland Park");
//        assertEquals(expectTeam.getId(),actualTeam.getId());
//    }
//
//    @Test
//    @Transactional
//    public void findByLocationTest(){
//        Team expectTeam = new Team();
//        expectTeam.setArena("Highland Park");
//        expectTeam.setConference("GWU");
//        expectTeam.setDivision("Graduate");
//        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
//        expectTeam.setFoundYear(instant);
//        expectTeam.setLocation("Highland Park");
//        expectTeam.setHistory("No History");
//        teamRepository.save(expectTeam);
//        Team actualTeam = teamService.findByLocation("Highland Park");
//        assertEquals(expectTeam.getId(),actualTeam.getId());
//    }
//
//    @Test
//    @Transactional
//    public void findByHistoryTest(){
//        Team expectTeam = new Team();
//        expectTeam.setArena("Highland Park");
//        expectTeam.setConference("GWU");
//        expectTeam.setDivision("Graduate");
//        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
//        expectTeam.setFoundYear(instant);
//        expectTeam.setLocation("Highland Park");
//        expectTeam.setHistory("No History");
//        teamRepository.save(expectTeam);
//        Team actualTeam = teamService.findByHistory("No History");
//        assertEquals(expectTeam.getId(),actualTeam.getId());
//    }
//
//    @Test
//    @Transactional
//    public void findByFoundYearTest(){
//        Team expectTeam = new Team();
//        expectTeam.setArena("Highland Park");
//        expectTeam.setConference("GWU");
//        expectTeam.setDivision("Graduate");
//        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
//        expectTeam.setFoundYear(instant);
//        expectTeam.setLocation("Highland Park");
//        expectTeam.setHistory("No History");
//        teamRepository.save(expectTeam);
//        List<Team> actualTeam = teamService.findByFoundYear(instant);
//        assertTrue(actualTeam.size()>0);
//    }
//
//
//
//
//
//
//
//
//}

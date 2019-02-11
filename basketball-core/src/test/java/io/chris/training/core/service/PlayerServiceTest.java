package io.chris.training.mvc.core.service;

import io.chris.training.config.AppConfig;
import io.chris.training.domain.Player;
import io.chris.training.repository.PlayersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class PlayerServiceTest {

    @Autowired
    private PlayersRepository playersRepository;

    @Autowired
    private PlayerService playerService;

    private LocalDate date = LocalDate.parse("1993-10-15");

    @Test
    @Transactional
    public void findByIdTest(){
        Player expectedPlayer = new Player();
        // in this case, we need to back to model/domain to check the variable setting
        expectedPlayer.setFirstName("chris");
        expectedPlayer.setLastName("xu");
        expectedPlayer.setHeight(6.00);
        expectedPlayer.setWeight(180.00);
        expectedPlayer.setPlayerPosition("SF");
        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
        expectedPlayer.setBorn(instant);
        playersRepository.save(expectedPlayer);
        Player actualPlayer = playerService.findById(expectedPlayer.getId());
        assertEquals(actualPlayer.getId(),expectedPlayer.getId());
    }

    @Test
    @Transactional
    public void findByFirstNameTest(){
        Player expectedPlayer = new Player();
        // in this case, we need to back to model/domain to check the variable setting
        expectedPlayer.setFirstName("chris");
        expectedPlayer.setLastName("xu");
        expectedPlayer.setHeight(6.00);
        expectedPlayer.setWeight(180.00);
        expectedPlayer.setPlayerPosition("SF");
        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
        expectedPlayer.setBorn(instant);
        playersRepository.save(expectedPlayer);
        List<Player> actualPlayer = playerService.findByFirstName("chris");
        assertTrue(actualPlayer.size()>0);
    }

    @Test
    @Transactional
    public void findByLastNameTest(){
        Player expectedPlayer = new Player();
        expectedPlayer.setFirstName("chris");
        expectedPlayer.setLastName("xu");
        expectedPlayer.setHeight(6.00);
        expectedPlayer.setWeight(180.00);
        expectedPlayer.setPlayerPosition("SF");
        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
        expectedPlayer.setBorn(instant);
        playersRepository.save(expectedPlayer);
        List<Player> actualPlayer = playerService.findByLastName("xu");
        assertTrue(actualPlayer.size()>0);
    }

    @Test
    @Transactional
    public void findByPlayerPositionTest(){
        Player expectedPlayer = new Player();
        expectedPlayer.setFirstName("chris");
        expectedPlayer.setLastName("xu");
        expectedPlayer.setHeight(6.00);
        expectedPlayer.setWeight(180.00);
        expectedPlayer.setPlayerPosition("SF");
        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
        expectedPlayer.setBorn(instant);
        playersRepository.save(expectedPlayer);
        List<Player> actualPlayer = playerService.findByPlayerPosition("SF");
        assertTrue(actualPlayer.size()>0);
    }

    @Test
    @Transactional
    public void findByBornTest(){
        Player expectedPlayer = new Player();
        expectedPlayer.setFirstName("chris");
        expectedPlayer.setLastName("xu");
        expectedPlayer.setHeight(6.00);
        expectedPlayer.setWeight(180.00);
        expectedPlayer.setPlayerPosition("SF");
        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
        expectedPlayer.setBorn(instant);
        playersRepository.save(expectedPlayer);
        List<Player> actualPlayer = playerService.findByBorn(instant);
        assertTrue(actualPlayer.size()>0);
    }

    @Test
    @Transactional
    public void findByHeightTest(){
        Player expectedPlayer = new Player();
        expectedPlayer.setFirstName("chris");
        expectedPlayer.setLastName("xu");
        expectedPlayer.setHeight(6.00);
        expectedPlayer.setWeight(180.00);
        expectedPlayer.setPlayerPosition("SF");
        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
        expectedPlayer.setBorn(instant);
        playersRepository.save(expectedPlayer);
        List<Player> actualPlayer = playerService.findByHeight(6.00);
        assertTrue(actualPlayer.size()>0);
    }

    @Test
    @Transactional
    public void findByWeightTest(){
        Player expectedPlayer = new Player();
        expectedPlayer.setFirstName("chris");
        expectedPlayer.setLastName("xu");
        expectedPlayer.setHeight(6.00);
        expectedPlayer.setWeight(180.00);
        expectedPlayer.setPlayerPosition("SF");
        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
        expectedPlayer.setBorn(instant);
        playersRepository.save(expectedPlayer);
        List<Player> actualPlayer = playerService.findByWeight(180.00);
        assertTrue(actualPlayer.size()>0);
    }

}

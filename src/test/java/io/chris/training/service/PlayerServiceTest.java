package io.chris.training.service;

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

import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class PlayerServiceTest {

    @Autowired
    private PlayersRepository playersRepository;

    @Autowired
    private PlayerService playerService;

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
        playersRepository.save(expectedPlayer);
        Player actualPlayer = playerService.findByFirstName("chris");
        assertEquals(actualPlayer.getId(),expectedPlayer.getId());
    }
}

package io.chris.training.mvc.api.v1;

import io.chris.training.domain.Player;
import io.chris.training.domain.Team;
import io.chris.training.core.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/api/player")
public class PlayerController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PlayerService playerService;

    @RequestMapping(method = RequestMethod.GET,value = "")
    public List<Player> findAll(){
        List<Player> result = playerService.findAll();
        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Player addPlayer(@RequestBody Player player){
        Player result = playerService.save(player);
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Player updatePlayer(@RequestBody Player player) {
        Player result = playerService.save(player);
        return result;
    }

    @RequestMapping(value = "/{Id}",method = RequestMethod.GET)
    public Player findPlayerById(@PathVariable("Id") Long Id){
        logger.debug("The player Id is:"+ Id);
        Player result = playerService.findById(Id);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"first_name"})
    public List<Player> findByFirstName(@RequestParam(value = "first_name") String firstName) {
        logger.debug("This first name is :"+ firstName);
        List<Player> result = playerService.findByFirstName(firstName);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"last_name"})
    public List<Player> findByLastName(@RequestParam(value = "last_name") String lastName) {
        logger.debug("This last name is :"+ lastName);
        List<Player> result = playerService.findByLastName(lastName);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"player_position"})
    public List<Player> findByPlayerPosition(@RequestParam(value = "player_position") String playerPosition) {
        logger.debug("This player position is :"+ playerPosition);
        List<Player> result = playerService.findByPlayerPosition(playerPosition);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"born"})
    public List<Player> findByBorn(@RequestParam(value = "born") Instant born) {
        logger.debug("This born is :"+ born);
        List<Player> result = playerService.findByBorn(born);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"height"})
    public List<Player> findByHeight(@RequestParam(value = "height") Double height) {
        logger.debug("This height is :"+ height);
        List<Player> result = playerService.findByHeight(height);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"weight"})
    public List<Player> findByWeight(@RequestParam(value = "weight") Double weight) {
        logger.debug("This weight is :"+ weight);
        List<Player> result = playerService.findByWeight(weight);
        return result;
    }

}

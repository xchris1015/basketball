package io.chris.training.api.v1;

import io.chris.training.domain.Player;
import io.chris.training.domain.Team;
import io.chris.training.service.PlayerService;
import io.chris.training.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/player")
public class PlayerController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/{Id}",method = RequestMethod.GET)
    public Player findPlayerById(@PathVariable("Id") Long Id){
        logger.debug("The player Id is:"+ Id);
        Player result = playerService.findById(Id);
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

}

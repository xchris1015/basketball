package io.chris.training.api.v1;

import io.chris.training.domain.Player;
import io.chris.training.domain.PlayerStatistics;
import io.chris.training.service.PlayerService;
import io.chris.training.service.PlayerStatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/playerstatistics")
public class PlayerStatisticsController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PlayerStatisticsService playerStatisticsService;

    @RequestMapping(method = RequestMethod.GET,value = "")
    public List<PlayerStatistics> findAll(){
        List<PlayerStatistics> result = playerStatisticsService.findAll();
        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    public PlayerStatistics addPlayerStatistics(@RequestBody PlayerStatistics playerStatistics){
        PlayerStatistics result = playerStatisticsService.addPlayerStatistics(playerStatistics);
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public PlayerStatistics updatePlayerStatistics(@RequestBody PlayerStatistics playerStatistics) {
        PlayerStatistics result = playerStatisticsService.addPlayerStatistics(playerStatistics);
        return result;
    }

    @RequestMapping(value = "/{Id}",method = RequestMethod.GET)
    public PlayerStatistics findPlayerStatisticsById(@PathVariable("Id") Long Id){
        logger.debug("The player Id is:"+ Id);
        PlayerStatistics result = playerStatisticsService.findById(Id);
        return result;
    }
}

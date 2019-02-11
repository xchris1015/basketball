package io.chris.training.mvc.api.v1;

import io.chris.training.domain.Player;
import io.chris.training.domain.PlayerStatistics;
import io.chris.training.core.service.PlayerStatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/playerstatistic")
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

    @RequestMapping(method = RequestMethod.GET,params = {"score"})
    public List<PlayerStatistics> findByScore(@RequestParam(value = "score") Double score) {
        logger.debug("This score is :"+ score);
        List<PlayerStatistics> result = playerStatisticsService.findByScore(score);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"rebound"})
    public List<PlayerStatistics> findByRebound(@RequestParam(value = "rebound") Double rebound) {
        logger.debug("This rebound is :"+ rebound);
        List<PlayerStatistics> result = playerStatisticsService.findByRebound(rebound);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"assistant"})
    public List<PlayerStatistics> findByAssistant(@RequestParam(value = "assistant") Double assistant) {
        logger.debug("This assistant is :"+ assistant);
        List<PlayerStatistics> result = playerStatisticsService.findByAssistant(assistant);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"steal"})
    public List<PlayerStatistics> findBySteal(@RequestParam(value = "steal") Double steal) {
        logger.debug("This steal is :"+ steal);
        List<PlayerStatistics> result = playerStatisticsService.findBySteal(steal);
        return result;
    }

}

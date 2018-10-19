package io.chris.training.api.v1;

import io.chris.training.domain.Team;
import io.chris.training.domain.User;
import io.chris.training.service.TeamService;
import io.chris.training.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/team")
public class TeamController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/{Id}",method = RequestMethod.GET)
    public Team findTeamById(@PathVariable("Id") Long Id){
        logger.debug("The team Id is:"+ Id);
        Team result = teamService.findById(Id);
        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Team addTeam(@RequestBody Team team){
        Team result = teamService.addTeam(team);
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Team updateTeam(@RequestBody Team team) {
        Team result = teamService.addTeam(team);
        return result;
    }

}

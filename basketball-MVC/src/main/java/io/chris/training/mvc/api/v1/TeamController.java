package io.chris.training.mvc.api.v1;

import io.chris.training.domain.Team;
import io.chris.training.domain.User;
import io.chris.training.core.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/api/team")
public class TeamController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TeamService teamService;

    @RequestMapping(method = RequestMethod.GET,value = "")
    public List<Team> findAllTeam(){
        List<Team> result = teamService.findAll();
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

    @RequestMapping(value = "/{Id}",method = RequestMethod.GET)
    public Team findTeamById(@PathVariable("Id") Long Id){
        logger.debug("The team Id is:"+ Id);
        Team result = teamService.findById(Id);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"conference"})
    public List<Team> findByConference(@RequestParam(value = "conference") String conference) {
        logger.debug("This conference is :"+ conference);
        List<Team> result = teamService.findByConference(conference);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"division"})
    public List<Team> findByDivision(@RequestParam(value = "division") String division) {
        logger.debug("This division is :"+ division);
        List<Team> result = teamService.findByDivision(division);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"found_year"})
    public List<Team> findByFoundYear(@RequestParam(value = "found_year") Instant foundYear) {
        logger.debug("This found year is :"+ foundYear);
        List<Team> result = teamService.findByFoundYear(foundYear);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"history"})
    public Team findByHistory(@RequestParam(value = "history") String history) {
        logger.debug("This history is :"+ history);
        Team result = teamService.findByHistory(history);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"arena"})
    public Team findByArena(@RequestParam(value = "arena") String arena) {
        logger.debug("This area is :"+ arena);
        Team result = teamService.findByArena(arena);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"location"})
    public Team findByLocation(@RequestParam(value = "location") String location) {
        logger.debug("This location is :"+ location);
        Team result = teamService.findByLocation(location);
        return result;
    }





}

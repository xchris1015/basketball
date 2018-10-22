package io.chris.training.service;

import io.chris.training.domain.Team;
import io.chris.training.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team findById(Long id){

        Optional<Team> result = teamRepository.findById(id);
        Team obj = result.get();
        return obj;

    }

    public List<Team> findAll(){
        List<Team> result = teamRepository.findAll();
        return result;

    }

    public List<Team> findByConference(String conference){
        List<Team> result = teamRepository.findByConference(conference);
        return result;

    }

    public List<Team> findByDivision(String division){
        List<Team> result = teamRepository.findByDivision(division);
        return result;

    }

    public List<Team> findByFoundYear(Instant foundYear){
        List<Team> result = teamRepository.findByFoundYear(foundYear);
        return result;

    }

    public Team findByHistory(String history){
        Optional<Team> result = teamRepository.findByHistory(history);
        Team obj = result.get();
        return obj;

    }

    public Team findByArena(String arena){
        Optional<Team> result = teamRepository.findByArena(arena);
        Team obj = result.get();
        return obj;

    }

    public Team findByLocation(String location){
        Optional<Team> result = teamRepository.findByLocation(location);
        Team obj = result.get();
        return obj;

    }

    public Team addTeam(Team team){
        Team result = teamRepository.save(team);
        return result;

    }
}

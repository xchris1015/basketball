package io.chris.training.service;

import io.chris.training.domain.Team;
import io.chris.training.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
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

    public Team findByConference(String conference){
        Optional<Team> result = teamRepository.findByConference(conference);
        Team obj = result.get();
        return obj;

    }

    public Team findByDivision(String division){
        Optional<Team> result = teamRepository.findByDivision(division);
        Team obj = result.get();
        return obj;

    }

    public Team findByFoundYear(Instant foundYear){
        Optional<Team> result = teamRepository.findByFoundYear(foundYear);
        Team obj = result.get();
        return obj;

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

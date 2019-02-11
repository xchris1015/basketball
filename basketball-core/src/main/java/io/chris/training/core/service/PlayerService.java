package io.chris.training.mvc.core.service;

import io.chris.training.mvc.core.domain.Player;
import io.chris.training.mvc.core.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayersRepository playersRepository;

    public Player findById(Long id){

        Optional<Player> result = playersRepository.findById(id);
        Player obj = result.get();
        return obj;

    }

    public List<Player> findAll(){
        List<Player> result = playersRepository.findAll();
        return result;
    }


    public List<Player> findByFirstName(String firstName){

        List<Player> result = playersRepository.findByFirstName(firstName);
        return result;

    }

    public List<Player> findByLastName(String lastName){

        List<Player> result = playersRepository.findByLastName(lastName);
        return result;

    }

    public List<Player> findByPlayerPosition(String playerPosition){

        List<Player> result = playersRepository.findByPlayerPosition(playerPosition);
        return result;

    }

    public List<Player> findByBorn(Instant born){

        List<Player> result = playersRepository.findByBorn(born);
        return result;

    }

    public List<Player> findByHeight(Double height){

        List<Player> result = playersRepository.findByHeight(height);
        return result;

    }

    public List<Player> findByWeight(Double weight){

        List<Player> result = playersRepository.findByWeight(weight);
        return result;

    }

    public Player save(Player player){
        Player result = playersRepository.save(player);
        return result;
    }


}

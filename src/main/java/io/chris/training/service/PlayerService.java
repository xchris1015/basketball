package io.chris.training.service;

import io.chris.training.domain.Player;
import io.chris.training.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayersRepository playersRepository;


    public Player findByFirstName(String firstName){

        Optional<Player> result = playersRepository.findByFirstName(firstName);
        Player obj = result.get();
        return obj;

    }

    public Player findByLastName(String lastName){

        Optional<Player> result = playersRepository.findByLastName(lastName);
        Player obj = result.get();
        return obj;

    }

    public Player findByPlayerPosition(String playerPosition){

        Optional<Player> result = playersRepository.findByPlayerPosition(playerPosition);
        Player obj = result.get();
        return obj;

    }

    public Player findByBorn(Instant born){

        Optional<Player> result = playersRepository.findByBorn(born);
        Player obj = result.get();
        return obj;

    }

    public Player findByHeight(Double height){

        Optional<Player> result = playersRepository.findByHeight(height);
        Player obj = result.get();
        return obj;

    }

    public Player findByWeight(Double weight){

        Optional<Player> result = playersRepository.findByWeight(weight);
        Player obj = result.get();
        return obj;

    }


}

package io.chris.training.service;

import io.chris.training.domain.Player;
import io.chris.training.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayersRepository playersRepository;

    public Player findByFirstName(String firstName){

        Optional<Player> outcomeFirstName = playersRepository.findByFirstName(firstName);
        Player obj = outcomeFirstName.get();
        return obj;

    }
}

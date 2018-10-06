package io.chris.training.service;

import io.chris.training.domain.User;
import io.chris.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User findByUsername(String username){
        Optional<User> result = userRepository.findByUsername(username);
        User obj = result.get();
        return obj;
    }

}

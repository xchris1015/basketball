package io.chris.training.service;

import io.chris.training.domain.User;
import io.chris.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findbyusername(String username){
        User result = userRepository.findByUsernameIgnoreCase(username);
        return result;
    }

}

package io.chris.training.service;

import io.chris.training.domain.User;
import io.chris.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
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

    public User findByFirstName(String firstName){
        Optional<User> result =userRepository.findByFirstName(firstName);
        User obj = result.get();
        return obj;
    }

    public User findByLastName(String lastName){
        Optional<User> result =userRepository.findByLastName(lastName);
        User obj = result.get();
        return obj;
    }

    public User findByEmail(String email){
        Optional<User> result =userRepository.findByEmail(email);
        User obj = result.get();
        return obj;
    }

    public User findByPasswords(String passwords){
        Optional<User> result =userRepository.findByPasswords(passwords);
        User obj = result.get();
        return obj;
    }

}

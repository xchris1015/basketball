package io.chris.training.service;

import io.chris.training.domain.Authority;
import io.chris.training.domain.User;
import io.chris.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User findById(Long id){

        Optional<User> result = userRepository.findById(id);
        User obj = result.get();
        return obj;

    }


    public List<User> findAll(){
        List<User> results = userRepository.findAll();
        return results;

    }

    public User findByUsername(String username){
        Optional<User> result = userRepository.findByUsername(username);
        User obj = result.get();
        return obj;
    }

    public List<User> findByFirstName(String firstName){
        List<User> result =userRepository.findByFirstName(firstName);
        return result;
    }

    public List<User> findByLastName(String lastName){
        List<User> result =userRepository.findByLastName(lastName);
        return result;
    }

    public User findByEmail(String email){
        Optional<User> result =userRepository.findByEmail(email);
        User obj = result.get();
        return obj;
    }

    public User addUser(User user){
        String encodedPassword = encoder.encode(user.getPasswords());
        user.setPassword(encodedPassword);
        User result = userRepository.save(user);
        return result;
    }





}

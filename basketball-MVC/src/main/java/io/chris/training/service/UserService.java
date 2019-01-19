package io.chris.training.service;

import io.chris.training.domain.Authority;
import io.chris.training.domain.User;
import io.chris.training.repository.AuthorityRepository;
import io.chris.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private AuthorityRepository authorityRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User findByID(Long Id){
        return userRepository.findById(Id).get();
    }



    // TODO transactional(readOnly = true) how to explain and how to use;
    // TODO Optional ifprsesent test
    // TODO find user by email or username
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
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setCreateAt(Instant.now());
        User result = userRepository.save(user);
        authorityService.addAuthority(user,"ROLE_REGISTERED_USER");
        return result;
    }


    public List<User> findByCreateAt(Instant createAt){
        List<User> results = userRepository.findByCreateAt(createAt);
        return results;

    }





}

package io.chris.training.core.service;

import io.chris.training.core.extension.exp.NotFoundException;
import io.chris.training.core.domain.User;
import io.chris.training.core.repository.AuthorityRepository;
import io.chris.training.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
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



    // TODO Optional ifprsesent test
    // TODO add ignore case
    public User findById(Long id){
        Optional<User> result = userRepository.findById(id);
        User obj = result.get();
        return obj;

    }

    public List<User> findAll(){
        List<User> results = userRepository.findAll();
        return results;

    }

    public User findByEmailOrUsername(String keyword) throws NotFoundException, NullPointerException {
        if (keyword==null || "".equals(keyword.trim())){
            throw new NullPointerException();
        }
            User user = userRepository.findByEmail(keyword);
        if (user==null){
            user = userRepository.findByUsername(keyword);
        }
        if (user==null){
            throw new NotFoundException("Could not find the User by Username Or Email");
        }
        return user;
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
        User result =userRepository.findByEmail(email);
        return result;
    }

    public User findByUsername(String username){
        User result =userRepository.findByUsername(username);
        return result;
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

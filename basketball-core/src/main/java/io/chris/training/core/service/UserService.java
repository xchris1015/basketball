package io.chris.training.core.service;

import io.chris.training.core.extension.exp.NotFoundException;
import io.chris.training.core.domain.User;
import io.chris.training.core.repository.AuthorityRepository;
import io.chris.training.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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


    public User findById(Long id) throws NullPointerException{
        if (id==null){
            throw new NullPointerException();
        }
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
            User user = userRepository.findByEmailIgnoreCase(keyword);
        if (user==null){
            user = userRepository.findByUsernameIgnoreCase(keyword);
        }
        if (user==null){
            throw new NotFoundException("Could not find the User by Username Or Email");
        }
        return user;
    }

    public List<User> findByFirstName(String firstName) throws NullPointerException,NotFoundException{
        if (firstName==null || "".equals(firstName.trim())){
            throw new NullPointerException();
        }
        List<User> result =userRepository.findByFirstNameIgnoreCase(firstName);
        if (result==null){
            throw new NotFoundException("Could not find the User by First Name");
        }
        return result;
    }

    public List<User> findByLastName(String lastName) throws NullPointerException,NotFoundException{
        if (lastName==null || "".equals(lastName.trim())){
            throw new NullPointerException();
        }
        List<User> result =userRepository.findByLastNameIgnoreCase(lastName);
        if (result==null){
            throw new NotFoundException("Could not find the User by Last Name");
        }
        return result;
    }

    public User findByEmail(String email) throws NullPointerException,NotFoundException{
        if (email==null || "".equals(email.trim())){
            throw new NullPointerException();
        }
        User result =userRepository.findByEmailIgnoreCase(email);
        if (result==null){
            throw new NotFoundException("Could not find the User by Email");
        }
        return result;
    }

    public User findByUsername(String username) throws NullPointerException, UsernameNotFoundException {
        if (username==null || "".equals(username.trim())){
            throw new NullPointerException();
        }
        User result =userRepository.findByUsernameIgnoreCase(username);
        if (result==null){
            throw new UsernameNotFoundException("Could not find the User by Username");
        }
        return result;
    }

    //TODO add limitation for password, and username?
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

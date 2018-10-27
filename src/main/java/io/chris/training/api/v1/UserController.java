package io.chris.training.api.v1;

import io.chris.training.domain.Player;
import io.chris.training.domain.User;
import io.chris.training.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<User> findAllUser(){
        List<User> users = userService.findAll();
        return users;
    }

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
        User result = userService.addUser(user);
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user) {
        User result = userService.addUser(user);
        return result;
    }

    @RequestMapping(value = "/{Id}",method = RequestMethod.GET)
    public User findUserById(@PathVariable("Id") Long Id){
        logger.debug("User variables is:" + Id);
        User user = userService.findById(Id);
        return user;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"first_name"})
    public List<User> findByFirstName(@RequestParam(value = "first_name") String firstName) {
        logger.debug("This first name is :"+ firstName);
        List<User> result = userService.findByFirstName(firstName);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"last_name"})
    public List<User> findByLastName(@RequestParam(value = "last_name") String lastName) {
        logger.debug("This last name is :"+ lastName);
        List<User> result = userService.findByLastName(lastName);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"username"})
    public User findByUsername(@RequestParam(value = "username") String username) {
        logger.debug("This username is :"+ username);
        User result = userService.findByUsername(username);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"email"})
    public User findByEmail(@RequestParam(value = "email") String email) {
        logger.debug("This email is :"+ email);
        User result = userService.findByEmail(email);
        return result;
    }



}

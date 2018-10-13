package io.chris.training.api.v1;

import io.chris.training.domain.User;
import io.chris.training.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    public User findUserById(Long Id){
        User user = userService.findById(Id);
        return user;
    }

    
}

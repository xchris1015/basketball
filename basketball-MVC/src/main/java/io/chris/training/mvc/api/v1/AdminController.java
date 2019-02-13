package io.chris.training.mvc.api.v1;

import io.chris.training.core.domain.User;
import io.chris.training.core.service.AuthorityService;
import io.chris.training.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/{Id}",params = {"authority"},method = RequestMethod.POST)
    public void updateUserAuthority(@PathVariable("Id") Long Id,@RequestParam(value = "authority") String authority){
        User user = userService.findById(Id);
        authorityService.addAuthority(user,authority);
    }


}

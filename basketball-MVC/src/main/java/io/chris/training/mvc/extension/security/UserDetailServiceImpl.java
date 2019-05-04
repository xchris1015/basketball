package io.chris.training.mvc.extension.security;

import io.chris.training.core.domain.Authority;
import io.chris.training.core.domain.User;
import io.chris.training.core.extension.exp.NotFoundException;
import io.chris.training.core.service.AuthorityService;
import io.chris.training.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    //TODO
    //MessageSource

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User domainUser = userService.findByUsername(username);
        List<Authority> authority = authorityService.findAuthoritiesByUser(domainUser);
        domainUser.setAuthorities(authority);
        return domainUser;
    }
}

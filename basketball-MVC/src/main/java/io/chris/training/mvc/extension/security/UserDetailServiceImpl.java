package io.chris.training.extension.security;

import io.chris.training.domain.Authority;
import io.chris.training.domain.User;
import io.chris.training.core.service.AuthorityService;
import io.chris.training.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public User loadUserByUsername(String username) {
        User domainUser = userService.findByUsername(username);
        List<Authority> authority = authorityService.findAuthoritiesByUser(domainUser);
        domainUser.setAuthorities(authority);
        return domainUser;
    }
}

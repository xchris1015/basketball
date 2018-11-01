package io.chris.training.extension.security;

import io.chris.training.domain.Authority;
import io.chris.training.domain.User;
import io.chris.training.service.AuthorityService;
import io.chris.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        Authority authority = authorityService.findAuthoritiesByUser(domainUser);
        List<Authority> obj = new ArrayList<>();
        obj.add(authority);
        domainUser.setAuthorities(obj);
        return domainUser;
    }
}

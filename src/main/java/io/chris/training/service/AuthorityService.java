package io.chris.training.service;

import io.chris.training.domain.Authority;
import io.chris.training.domain.User;
import io.chris.training.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public List<Authority> findAuthoritiesByUser(User user){
        List<Authority> result = authorityRepository.findAuthoritiesByUser(user);
        return result;
    }
}

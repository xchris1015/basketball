package io.chris.training.core.service;

import io.chris.training.core.domain.Authority;
import io.chris.training.core.domain.User;
import io.chris.training.core.repository.AuthorityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class AuthorityService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthorityRepository authorityRepository;

    public List<Authority> findAuthoritiesByUser(User user){
        List<Authority> result = authorityRepository.findAuthoritiesByUser(user);
        return result;
    }

    @Transactional
    //TODO more efficient how to check element already in the set or use sql
    public Authority addAuthority(User user,String authorityString){

        List<Authority> authorities = authorityRepository.findAuthoritiesByUser(user);
        List<String> authoritiesString = new LinkedList<>();
        Set<String> foo = new HashSet<>();

        for (int i =0;i<authorities.size();i++){
            authoritiesString.add(authorities.get(i).getAuthority());
            foo.add(authorities.get(i).getAuthority());
        }

        foo.add(authorityString);

        if (authorities.size()<foo.size()){
            Authority result = new Authority(user,authorityString);
            return authorityRepository.save(result);
        }else{
            logger.info("This role already exist!");
            return null;
        }
    }




}

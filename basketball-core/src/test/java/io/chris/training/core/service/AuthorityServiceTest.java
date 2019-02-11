package io.chris.training.mvc.core.service;

import io.chris.training.config.AppConfig;
import io.chris.training.domain.Authority;
import io.chris.training.domain.Player;
import io.chris.training.domain.User;
import io.chris.training.repository.AuthorityRepository;
import io.chris.training.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class AuthorityServiceTest {

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void findAuthoritiesByUserTest() {
        Authority expectedAuthority = new Authority();
        User user = new User();
        expectedAuthority.setAuthority("ADMIN");
        expectedAuthority.setUser(user);
        user.setUsername("xchris6");
        user.setEmail("xchris1015@gmail.com6");
        user.setFirstName("chris6");
        user.setLastName("xu6");
        user.setPassword("password6");
        userRepository.save(user);
        authorityRepository.save(expectedAuthority);
        List<Authority> actualAuthority = authorityService.findAuthoritiesByUser(user);
        assertEquals(actualAuthority.size(),1);

    }

    @Test
    @Transactional
    public void addAuthorityTest() {
        Authority expectedAuthority = new Authority();
        User user = new User();
        expectedAuthority.setAuthority("ADMIN");
        expectedAuthority.setUser(user);
        user.setUsername("xchris6");
        user.setEmail("xchris1015@gmail.com6");
        user.setFirstName("chris6");
        user.setLastName("xu6");
        user.setPassword("password6");
        userRepository.save(user);
        authorityRepository.save(expectedAuthority);
        authorityService.addAuthority(user,"COACH");
        authorityService.addAuthority(user,"ADMIN");
        List<Authority> actualAuthority1 = authorityService.findAuthoritiesByUser(user);
        assertEquals(actualAuthority1.size(),2);

    }
}
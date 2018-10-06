package io.chris.training.service;

import io.chris.training.config.AppConfig;
import io.chris.training.domain.User;
import io.chris.training.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")

public class UserServiceTest extends UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Transactional
    @Test
    public void findByUsernameTest() {
        User ExpectedResult = new User();
        ExpectedResult.setUsername("xchris");
        ExpectedResult.setEmail("xchris1015@gmail.com");
        ExpectedResult.setFirstName("chris");
        ExpectedResult.setLastName("xu");
        ExpectedResult.setPasswords("password");
        userRepository.save(ExpectedResult);
        User actualResult = userService.findByUsername("xchris");
        assertEquals(actualResult.getId(), ExpectedResult.getId());
    }

    @Transactional
    @Test
    public void findByFirstNameTest() {
        User ExpectedResult = new User();
        ExpectedResult.setUsername("xchris");
        ExpectedResult.setEmail("xchris1015@gmail.com");
        ExpectedResult.setFirstName("chris");
        ExpectedResult.setLastName("xu");
        ExpectedResult.setPasswords("password");
        userRepository.save(ExpectedResult);
        User actualResult = userService.findByFirstName("chris");
        assertEquals(actualResult.getId(), ExpectedResult.getId());
    }


    @Transactional
    @Test
    public void findByLastNameTest(){
        User ExpectedResult = new User();
        ExpectedResult.setUsername("xchris");
        ExpectedResult.setEmail("xchris1015@gmail.com");
        ExpectedResult.setFirstName("chris");
        ExpectedResult.setLastName("xu");
        ExpectedResult.setPasswords("password");
        userRepository.save(ExpectedResult);
        User actualResult=userService.findByLastName("xu");
        assertEquals(actualResult.getId(),ExpectedResult.getId());
    }

    @Transactional
    @Test
    public void findByEmailTest(){
        User ExpectedResult = new User();
        ExpectedResult.setUsername("xchris");
        ExpectedResult.setEmail("xchris1015@gmail.com");
        ExpectedResult.setFirstName("chris");
        ExpectedResult.setLastName("xu");
        ExpectedResult.setPasswords("password");
        userRepository.save(ExpectedResult);
        User actualResult=userService.findByEmail("xchris1015@gmail.com");
        assertEquals(actualResult.getId(),ExpectedResult.getId());
    }

    @Transactional
    @Test
    public void findByPasswordTest(){
        User ExpectedResult = new User();
        ExpectedResult.setUsername("xchris");
        ExpectedResult.setEmail("xchris1015@gmail.com");
        ExpectedResult.setFirstName("chris");
        ExpectedResult.setLastName("xu");
        ExpectedResult.setPasswords("password");
        userRepository.save(ExpectedResult);
        User actualResult=userService.findByPasswords("password");
        assertEquals(actualResult.getId(),ExpectedResult.getId());
    }

}


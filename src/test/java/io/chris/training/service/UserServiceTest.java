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
    public void findByIdTest() {
        User expectedResult = new User();
        expectedResult.setUsername("xchris");
        expectedResult.setEmail("xchris1015@gmail.com");
        expectedResult.setFirstName("chris");
        expectedResult.setLastName("xu");
        expectedResult.setPasswords("password");
        userRepository.save(expectedResult);
        User actualResult = userService.findById(expectedResult.getId());
        assertEquals(actualResult.getId(), expectedResult.getId());
    }

    @Transactional
    @Test
    public void findByUsernameTest() {
        User expectedResult = new User();
        expectedResult.setUsername("xchris");
        expectedResult.setEmail("xchris1015@gmail.com");
        expectedResult.setFirstName("chris");
        expectedResult.setLastName("xu");
        expectedResult.setPasswords("password");
        userRepository.save(expectedResult);
        User actualResult = userService.findByUsername("xchris");
        assertEquals(actualResult.getId(), expectedResult.getId());
    }

    @Transactional
    @Test
    public void findByFirstNameTest() {
        User expectedResult = new User();
        expectedResult.setUsername("xchris");
        expectedResult.setEmail("xchris1015@gmail.com");
        expectedResult.setFirstName("chris");
        expectedResult.setLastName("xu");
        expectedResult.setPasswords("password");
        userRepository.save(expectedResult);
        User actualResult = userService.findByFirstName("chris");
        assertEquals(actualResult.getId(), expectedResult.getId());
    }


    @Transactional
    @Test
    public void findByLastNameTest(){
        User expectedResult = new User();
        expectedResult.setUsername("xchris");
        expectedResult.setEmail("xchris1015@gmail.com");
        expectedResult.setFirstName("chris");
        expectedResult.setLastName("xu");
        expectedResult.setPasswords("password");
        userRepository.save(expectedResult);
        User actualResult=userService.findByLastName("xu");
        assertEquals(actualResult.getId(),expectedResult.getId());
    }

    @Transactional
    @Test
    public void findByEmailTest(){
        User expectedResult = new User();
        expectedResult.setUsername("xchris");
        expectedResult.setEmail("xchris1015@gmail.com");
        expectedResult.setFirstName("chris");
        expectedResult.setLastName("xu");
        expectedResult.setPasswords("password");
        userRepository.save(expectedResult);
        User actualResult=userService.findByEmail("xchris1015@gmail.com");
        assertEquals(actualResult.getId(),expectedResult.getId());
    }

    @Transactional
    @Test
    public void findByPasswordTest(){
        User expectedResult = new User();
        expectedResult.setUsername("xchris");
        expectedResult.setEmail("xchris1015@gmail.com");
        expectedResult.setFirstName("chris");
        expectedResult.setLastName("xu");
        expectedResult.setPasswords("password");
        userRepository.save(expectedResult);
        User actualResult=userService.findByPasswords("password");
        assertEquals(actualResult.getId(),expectedResult.getId());
    }

}


package io.chris.training.mvc.services;

import io.chris.training.core.extension.exp.NotFoundException;
import io.chris.training.core.service.AuthorityService;
import io.chris.training.core.service.UserService;
import io.chris.training.mvc.config.AppConfig;
import io.chris.training.core.domain.Authority;
import io.chris.training.core.domain.User;
import io.chris.training.mvc.extension.security.JwtTokenUtil;
import io.chris.training.mvc.extension.security.UserDetailServiceImpl;
import io.chris.training.core.repository.AuthorityRepository;
import io.chris.training.core.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.LiteDevice;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

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

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private User expectedResult = new User();

    private User nullUser = null;

    LocalDate date = LocalDate.parse("1993-10-15");

    @Before
    public void setUp() throws Exception{
        expectedResult.setUsername("xchris");
        expectedResult.setEmail("xchris1015@gmail.com");
        expectedResult.setFirstName("chris");
        expectedResult.setLastName("xu");
        expectedResult.setPassword("password");
        userRepository.save(expectedResult);
    }

    @Transactional
    @Test
    public void findByIdTest() {
        User actualResult = userService.findById((expectedResult.getId()));
        assertEquals(actualResult.getId(), expectedResult.getId());
    }

    @Transactional
    @Test(expected = NullPointerException.class)
    public void findByIdNullPointerExceptionTest() {
        User actualResult = userService.findById(null);
    }

    @Transactional
    @Test(expected = NotFoundException.class)
    public void findByIdNotFoundExceptionTest() {
        User actualResult = userService.findById(null);
    }




    @Transactional
    @Test
    public void findByUsernameTest() {
        User actualResult = userService.findByUsername("xchris7");
        assertEquals(actualResult.getId(), expectedResult.getId());
    }

    @Transactional
    @Test
    public void findByFirstNameTest() throws NullPointerException, NotFoundException {
        List<User> actualResult = userService.findByFirstName("chris7");
        assertTrue(actualResult.size()>0);
    }


    @Transactional
    @Test
    public void findByLastNameTest()throws NullPointerException, NotFoundException{
        User expectedResult = new User();
        expectedResult.setUsername("xchris7");
        expectedResult.setEmail("xchris1015@gmail.com7");
        expectedResult.setFirstName("chris7");
        expectedResult.setLastName("xu7");
        expectedResult.setPassword("password7");
        userRepository.save(expectedResult);
        List<User> actualResult=userService.findByLastName("xu7");
        assertTrue(actualResult.size()>0);
   }

    @Transactional
    @Test
    public void findByEmailTest()throws NullPointerException, NotFoundException{
        User expectedResult = new User();
        expectedResult.setUsername("xchris7");
        expectedResult.setEmail("xchris1015@gmail.com7");
        expectedResult.setFirstName("chris7");
        expectedResult.setLastName("xu7");
        expectedResult.setPassword("password7");
        userRepository.save(expectedResult);
        User actualResult=userService.findByEmail("xchris1015@gmail.com7");
        assertEquals(actualResult.getId(),expectedResult.getId());
    }

    @Test
    @Transactional
    public void loadUserByUsernameTest()throws NullPointerException, UsernameNotFoundException {
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
        UserDetails user1 = userDetailServiceImpl.loadUserByUsername("xchris6");
        assertEquals(user,user1);
    }

    @Test
    @Transactional
    public void getUsernameFromTokenTest(){
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
        String token = jwtTokenUtil.generateToken(user,new LiteDevice());
        String actualUsername = jwtTokenUtil.getUsernameFromToken(token);
        assertEquals(user.getUsername(),actualUsername);
    }

    @Test
    @Transactional
    public void findByCreateAtTest(){
        Authority expectedAuthority = new Authority();
        User user = new User();
        expectedAuthority.setAuthority("ADMIN");
        expectedAuthority.setUser(user);
        user.setUsername("xchris6");
        user.setEmail("xchris1015@gmail.com6");
        user.setFirstName("chris6");
        user.setLastName("xu6");
        user.setPassword("password6");
        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
        user.setCreateAt(instant);
        userRepository.save(user);
        authorityRepository.save(expectedAuthority);
        List<User> actualUsers = userRepository.findByCreateAt(instant);
        assertEquals(actualUsers.get(0),user);
    }


    @Test
    @Transactional
    public void getCreatedAtFromTokenTest(){
        Authority expectedAuthority = new Authority();
        User user = new User();
        expectedAuthority.setAuthority("ADMIN");
        expectedAuthority.setUser(user);
        user.setUsername("xchris6");
        user.setEmail("xchris1015@gmail.com6");
        user.setFirstName("chris6");
        user.setLastName("xu6");
        user.setPassword("password6");
        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
        user.setCreateAt(instant);
        userRepository.save(user);
        authorityRepository.save(expectedAuthority);

        String token = jwtTokenUtil.generateToken(user,new LiteDevice());
        Instant actualCreateAt = jwtTokenUtil.getCreatedAtFromToken(token);
        assertEquals(user.getCreateAt(),actualCreateAt);
    }

    @Test
    @Transactional
    public void addUserTest(){

        User user = new User();
        user.setUsername("xchris6");
        user.setEmail("xchris1015@gmail.com6");
        user.setFirstName("chris6");
        user.setLastName("xu6");
        user.setPassword("password6");
        userRepository.save(user);
        User user1 = userService.addUser(user);
        assertTrue(user1.getPassword()!="password6");
        assertTrue(authorityService.findAuthoritiesByUser(user1).size()>=1);

    }







}


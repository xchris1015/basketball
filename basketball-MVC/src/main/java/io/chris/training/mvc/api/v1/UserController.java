package io.chris.training.mvc.api.v1;

import io.chris.training.core.domain.JsView;
import io.chris.training.core.domain.User;
import io.chris.training.core.extension.Comparator;
import io.chris.training.core.extension.exp.NotFoundException;
import io.chris.training.core.repository.UserRepository;
import io.chris.training.core.service.AuthorityService;
import io.chris.training.core.service.UserService;
import io.chris.training.mvc.extension.security.JwtTokenUtil;
import io.chris.training.mvc.extension.security.RestAuthenticationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/user")
public class UserController extends BaseController{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    static final String TOEKN_KEY = "token";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<User> findAllUser(){
        List<User> users = userService.findAll();
        return users;
    }


    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
        User result = userService.addUser(user);
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user) {
        User result = userService.addUser(user);
        return result;
    }
// TODO change the return method, also design two argument API
    @RequestMapping(value = "/{Id}",method = RequestMethod.GET)
    public User findUserById(@PathVariable("Id") Long Id){
        setJsonViewClass(JsView.Admin.class);
        disableMapperFeature_DEFAULT_VIEW_INCLUSION();
        logger.debug("User variables is:" + Id);
        User user = userService.findById(Id);
//        return userService.findById(new User(Id)).get();
        return user;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"first_name"})
    public List<User> findByFirstName(@RequestParam(value = "first_name") String firstName) throws NotFoundException {
        logger.debug("This first name is :"+ firstName);
        List<User> result = userService.findByFirstName(firstName);
        Comparator comparator = new Comparator();
        Collections.sort(result,comparator);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"last_name"})
    public List<User> findByLastName(@RequestParam(value = "last_name") String lastName) throws NotFoundException{
        logger.debug("This last name is :"+ lastName);
        List<User> result = userService.findByLastName(lastName);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"username"})
    public User findByUsername(@RequestParam(value = "username") String username) {
        logger.debug("This username is :"+ username);
        User result = userService.findByUsername(username);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET,params = {"email"})
    public User findByEmail(@RequestParam(value = "email") String email) throws NotFoundException{
        logger.debug("This email is :"+ email);
        User result = userService.findByEmail(email);
        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<?> login(@RequestBody RestAuthenticationRequest authenticationRequest, Device device) throws NullPointerException, NotFoundException {
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        logger.info("this username is:"+username);
        logger.info("this password is:"+password);
        try{
            Authentication notFullyAuthentication = new UsernamePasswordAuthenticationToken(username,password);
            final Authentication authentication = authenticationManager.authenticate(notFullyAuthentication);
            try {
                final UserDetails userDetails = userService.findByEmailOrUsername(username);
                final String token = jwtTokenUtil.generateToken(userDetails,device);
                Map<String, Object> Jsontoken = new HashMap<>();
                Jsontoken.put(TOEKN_KEY,token);
                return ResponseEntity.ok(Jsontoken);
            }catch (NotFoundException e){
                logger.info("This user does not exist");
                return  ResponseEntity.notFound().build();
            }

        }catch(AuthenticationException ex){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("authentication failure, please check your username or password");
        }

    }







}

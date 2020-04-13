package com.test.JsonComparator.controller;

import com.test.JsonComparator.model.User;
import com.test.JsonComparator.repository.UserRepository;
import com.test.JsonComparator.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 * @author : Swapil S
 * @created on : 04/10/2020, Fri
 **/

@Api(value = "this class is used to sign up")
@RestController
@RequestMapping(value = UserController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    UserRepository userRepository;
    UserService userService;
    @Autowired
    public UserController(UserRepository userRepository, UserService userService){

        this.userService = userService;
        this.userRepository = userRepository;
    }
    static final String BASE_URL = "/api/v1/users";

    @ApiOperation(value = "this api is to get all users")
    @RequestMapping(value = "/getUser/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    private List<User> getUser(){
        return  userService.getUser();
    }


    @ApiOperation(value = "this api is to get user by id")
    @RequestMapping(value = "/getUser/{userId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    private Optional<User> getUser(@PathVariable long userId){
        return  userService.getUser(userId);
    }

    @ApiOperation(value = "this operation is to sign-up user")
    @RequestMapping(value = "/sign-up", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}

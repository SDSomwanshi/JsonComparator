package com.test.JsonComparator.service.impl;

import com.test.JsonComparator.model.User;
import com.test.JsonComparator.repository.UserRepository;
import com.test.JsonComparator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author : Swapil S
 * @created on : 04/10/2020, Fri
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    public Optional<User> getUser(long id){
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @Override
    public void createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id){
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository :: delete);
    }

    @Override
    public User updateUser(User user){
        User user1 = userRepository.save(user);
        return user1;
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }
}

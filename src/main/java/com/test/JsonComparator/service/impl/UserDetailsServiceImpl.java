package com.test.JsonComparator.service.impl;

import com.test.JsonComparator.model.User;
import com.test.JsonComparator.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
/**
 * @author : Swapil S
 * @created on : 04/10/2020, Fri
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    UserRepository userRepository;
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User applicationUser = userRepository.findByUsername(userName);
        if(applicationUser == null) {
            throw new UsernameNotFoundException(userName);
        }
        return new org.springframework.security.core.userdetails.User(applicationUser.getUsername(),
                applicationUser.getPassword(), Collections.emptyList());
    }

}

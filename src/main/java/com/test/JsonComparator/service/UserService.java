package com.test.JsonComparator.service;

import com.test.JsonComparator.model.User;

import java.util.List;
import java.util.Optional;

/**
 * @author : Swapil S
 * @created on : 04/10/2020, Fri
 **/
public interface UserService {
  Optional<User> getUser(long id);
  void createUser(User user);
  void deleteUserById(long id);
  User updateUser(User user);
  List<User> getUser();
}

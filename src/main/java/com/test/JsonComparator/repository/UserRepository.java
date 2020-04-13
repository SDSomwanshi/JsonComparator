package com.test.JsonComparator.repository;

import com.test.JsonComparator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Swapil S
 * @created on : 04/10/2020, Fri
 **/
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

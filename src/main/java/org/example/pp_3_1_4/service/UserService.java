package org.example.pp_3_1_4.service;

import org.example.pp_3_1_4.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    void add(User user);
    void update(User user);
    void delete(User user);
    User getUserById(int id);
    User getUserByUsername(String username);
    User findById(int id);
}

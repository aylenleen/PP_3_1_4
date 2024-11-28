package org.example.pp_3_1_4.service;

import org.example.pp_3_1_4.dao.UserRepository;
import org.example.pp_3_1_4.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    @Lazy
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void add(User user) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        User savedUser = userRepository.getReferenceById(user.getId());
        if (!savedUser.getPassword().equals(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getReferenceById((long) id);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById((long) id).get();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}

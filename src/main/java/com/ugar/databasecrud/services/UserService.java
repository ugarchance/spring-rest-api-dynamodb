package com.ugar.databasecrud.services;

import com.ugar.databasecrud.entity.User;
import com.ugar.databasecrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUser(User user) {
        user.setUser_password(passwordEncoder.encode(user.getUser_password()));
        return userRepository.save(user);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Kullanıcıya rol ekleme
    public void addRoleToUser(String username, String role) {
        User user = findUserByUsername(username);
        if (user != null) {
            user.getRoleIds().add(role);
            userRepository.save(user);
        }
    }

}

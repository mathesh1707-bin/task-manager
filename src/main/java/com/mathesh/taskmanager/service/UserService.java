package com.mathesh.taskmanager.service;

import java.util.List;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mathesh.taskmanager.dto.LoginRequest;
import com.mathesh.taskmanager.model.User;
import com.mathesh.taskmanager.repository.UserRepository;

@Service
public class UserService {
    
    private UserRepository repo;
    private PasswordEncoder passwordEncoder;
    


    public UserService(UserRepository repo,PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder=passwordEncoder;
    }
    

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public User LoginUser(LoginRequest request) {
        User user = repo.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("Email not Foung"));
        boolean isMatch = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!isMatch) {
            throw new RuntimeException("Invalid Credentials");
        }
        return user;
    }
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }
    
    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

    public User updateUser(Long id, User user) {
        User existing_user = repo.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        existing_user.setEmail(user.getEmail());
        existing_user.setUsername(user.getUsername());
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
        existing_user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return repo.save(existing_user);
    }

}
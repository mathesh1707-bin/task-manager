package com.mathesh.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mathesh.taskmanager.model.User;
import com.mathesh.taskmanager.repository.UserRepository;

@Service
public class UserService {
    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User registerUser(User user) {
        return repo.save(user);
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
        existing_user.setPassword(user.getPassword());
        return repo.save(existing_user);
    }

}
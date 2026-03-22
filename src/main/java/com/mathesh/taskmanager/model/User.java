package com.mathesh.taskmanager.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String email;
    private String password;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;
    

    public User(){}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    public List<Task> getTasks() {
        return tasks;
    }
    
    public Long getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
package com.mathesh.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mathesh.taskmanager.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
}
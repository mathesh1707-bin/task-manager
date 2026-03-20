package com.mathesh.taskmanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mathesh.taskmanager.model.Task;
import com.mathesh.taskmanager.service.TaskService;

@RestController
@RequestMapping("/users/{userId}/tasks")
public class TaskController {
    private TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task createTask(@PathVariable Long userId, @RequestBody Task task) {
        return service.createTaskForUser(userId, task);
    }

    @GetMapping
    public List<Task> getTasksByUser(@PathVariable Long userId) {
        return service.getTasksByUser(userId);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id,@PathVariable Long userId) {
        return service.getTaskById(id,userId);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,@PathVariable Long userId, @RequestBody Task task) {
        return service.updateTask(id,userId, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id,@PathVariable Long userId) {
        service.deleteTask(id,userId);
    }
}

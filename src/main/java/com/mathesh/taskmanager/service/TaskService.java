package com.mathesh.taskmanager.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.mathesh.taskmanager.model.Task;
import com.mathesh.taskmanager.model.User;
import com.mathesh.taskmanager.repository.TaskRepository;
import com.mathesh.taskmanager.repository.UserRepository;

@Service
public class TaskService {
    private TaskRepository repo;
    private UserRepository user_repo;

    public TaskService(UserRepository user_repo, TaskRepository repo) {
        this.user_repo = user_repo;
        this.repo = repo;
    }

    public Task createTaskForUser(Long userId, Task task) {
        User user = user_repo.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        task.setUser(user);
        return repo.save(task);
    }
    
    public Task getTaskById(Long id, Long userId) {
        return repo.findByIdAndUserId(id, userId).orElseThrow(()->new RuntimeException("Task Not Found For This User"));
    }

    public List<Task> getTasksByUser(Long userId) {
    user_repo.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
    return repo.findByUserId(userId);
    }

    public void deleteTask(Long id,Long userId) {
        Task existing = repo.findByIdAndUserId(id, userId).orElseThrow(() -> new RuntimeException("Task Not Found For This User"));
        repo.delete(existing);
    }

    public Task updateTask(Long id,Long userId, Task task) {
        Task existing_task = repo.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new RuntimeException("Task Not Found For This User"));
        existing_task.setTitle(task.getTitle());
        existing_task.setDescription(task.getDescription());
        existing_task.setCompleted(task.isCompleted());
        return repo.save(existing_task);
    }
}

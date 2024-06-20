package com.project.todoapplication.service;

import com.project.todoapplication.model.Task;
import com.project.todoapplication.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;

    public Task CreateNewTask(Task task) {
        return taskRepo.save(task);
    }

    public List<Task> GetAllTasks() {
        return taskRepo.findAll();
    }

    public Task GetTaskById(int id) {
        return taskRepo.findById(id);
    }

    public List<Task> findAllCompletedTask() {
        return  taskRepo.findByCompletedTrue();
    }

    public List<Task>findAllUncompletedTask() {
        return  taskRepo.findByCompletedFalse();
    }

    public Task UpdateTask(Task task) {
        return taskRepo.save(task);
    }

    public void DeleteTask(int id) {
        taskRepo.deleteById(id);
    }








}

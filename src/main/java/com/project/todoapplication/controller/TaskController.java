package com.project.todoapplication.controller;


import com.project.todoapplication.model.Task;
import com.project.todoapplication.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.GetAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        return ResponseEntity.ok(taskService.GetTaskById(id));
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTasks() {
        return ResponseEntity.ok(taskService.findAllCompletedTask());
    }

    @GetMapping("/uncompleted")
    public ResponseEntity<List<Task>> getAllUncompletedTasks() {
        return ResponseEntity.ok(taskService.findAllUncompletedTask());
    }

    @GetMapping("/start-date")
    public ResponseEntity<List<Task>> getTasksByStartDate(@RequestParam LocalDate startDate) {
        return ResponseEntity.ok(taskService.findTaskByStartDate(startDate));
    }

    @GetMapping("/end-date")
    public ResponseEntity<List<Task>> getTasksByEndDate(@RequestParam LocalDate endDate) {
        return ResponseEntity.ok(taskService.findTaskByEndDate(endDate));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<Task>> getTasksByDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return  ResponseEntity.ok(taskService.findTaskByStartDateAndEndDate(startDate,endDate));
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.CreateNewTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable  int id, @RequestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok(taskService.UpdateTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable int id) {
        taskService.DeleteTask(id);
        return ResponseEntity.ok(true);
    }



}

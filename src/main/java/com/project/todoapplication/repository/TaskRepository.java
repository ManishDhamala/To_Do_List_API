package com.project.todoapplication.repository;

import com.project.todoapplication.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    public Task findById(int id);
    public Task findByTask(String task);


    public List<Task> findAll();
    public List<Task>findByCompletedTrue();
    public List<Task> findByCompletedFalse();


}

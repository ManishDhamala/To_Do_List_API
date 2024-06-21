package com.project.todoapplication.repository;

import com.project.todoapplication.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

     public Task findById(int id);
     Task findByTask(String task);


    List<Task> findAll();
    List<Task>findByCompletedTrue();
    List<Task> findByCompletedFalse();

    List<Task> findByStartDate(LocalDate startDate);
    List<Task> findByEndDate(LocalDate endDate);
    List<Task> findByStartDateAndEndDate(LocalDate startDate, LocalDate endDate);


}

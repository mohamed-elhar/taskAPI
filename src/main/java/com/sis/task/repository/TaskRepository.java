package com.sis.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sis.task.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}

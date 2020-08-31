package com.sis.task.service;

import java.util.List;
import java.util.Optional;

import com.sis.task.dto.TaskDto;
import com.sis.task.entity.Task;

public interface TaskService {

	Task save(TaskDto taskDto);
	
	Task update(TaskDto taskDto);
	
	void delete(Long id);
	
	List<TaskDto> getAll();
	
	Optional<Task> findById(Long id);
	
}

package com.sis.task.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sis.task.dto.TaskDto;
import com.sis.task.entity.Task;
import com.sis.task.repository.TaskRepository;
import com.sis.task.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Task save(TaskDto taskDto) {
		Task task = modelMapper.map(taskDto, Task.class);
		return taskRepository.save(task);
	}

	@Override
	public Task update(TaskDto taskDto) {
		return save(taskDto);
	}

	@Override
	public void delete(Long id) {
		taskRepository.deleteById(id);
	}

	@Override
	public List<TaskDto> getAll() {
		List<Task> tasks = taskRepository.findAll();
		return tasks.stream()
					.map(task -> modelMapper.map(task, TaskDto.class))
					.collect(Collectors.toList());
	}

	@Override
	public Optional<Task> findById(Long id) {
		return taskRepository.findById(id);
	}

}

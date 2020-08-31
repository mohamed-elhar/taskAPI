package com.sis.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sis.task.dto.TaskDto;
import com.sis.task.entity.Task;
import com.sis.task.exception.TaskNotFoundException;
import com.sis.task.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.OK)
	public TaskDto save(@Validated @RequestBody TaskDto taskDto) {
		Task task = taskService.save(taskDto);
		taskDto.setId(task.getId());
		return taskDto;
	}
	
	@PutMapping("/update")
	@ResponseStatus(code = HttpStatus.OK)
	public TaskDto update(@RequestBody TaskDto taskDto){
		taskService.findById(taskDto.getId())
					.orElseThrow(()-> new TaskNotFoundException("Task id : "+taskDto.getId()+" not found")	);
		return save(taskDto);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		taskService.findById(id)
					.orElseThrow(()-> new TaskNotFoundException("Task id : "+id+" not found")	);
		taskService.delete(id);
	}
	
	@GetMapping("/findAll")
	@ResponseStatus(code = HttpStatus.OK)
	public List<TaskDto> getAll() {
		return taskService.getAll();
	}
}

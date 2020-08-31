package com.sis.task.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class TaskDto {

	private Long id;
	@NotNull(message = "Label shouldn't be null ")
	private String label;

	private String description;
	
	@NotNull(message = "Start date shouldn't be null ")
	private LocalDate startDate;
	
	@NotNull(message = "End date shouldn't be null ")
	private LocalDate endDate;
	
	private String comment; 
}

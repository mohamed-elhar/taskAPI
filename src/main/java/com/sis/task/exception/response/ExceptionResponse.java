package com.sis.task.exception.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor @Getter @ToString
public class ExceptionResponse {

	private LocalDateTime timeStamp;
	private int status;
	private String message;
}

package com.tutorial.QuizApp.DTO;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResponseDTO {
	HttpStatus httpStatusCode;
	String message;
}

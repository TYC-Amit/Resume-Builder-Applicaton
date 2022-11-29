package com.te.resumebuilder.resumecustomexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.resumebuilder.excption.ResumeBuilderNotFoundException;
import com.te.resumebuilder.response.ResponseResume;

@RestControllerAdvice
public class ResumeExceptionHandler {
	
	@ExceptionHandler(ResumeBuilderNotFoundException.class)
	public ResponseEntity<ResponseResume> resumeNotHandler(ResumeBuilderNotFoundException exception){
		
		return new ResponseEntity<>(new ResponseResume(false,exception.getMessage(), null),HttpStatus.BAD_REQUEST);
	}
}

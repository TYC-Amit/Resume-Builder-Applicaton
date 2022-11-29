package com.te.resumebuilder.excption;

@SuppressWarnings("serial")
public class ResumeBuilderNotFoundException extends RuntimeException{
         
	public ResumeBuilderNotFoundException(String message) {
		super(message);
	}
}

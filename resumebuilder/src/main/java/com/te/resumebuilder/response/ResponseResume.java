package com.te.resumebuilder.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResume {
	
	private boolean error;
	private String message;
	private Object data;
}

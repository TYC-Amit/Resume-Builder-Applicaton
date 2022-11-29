package com.te.resumebuilder.pojo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.resumebuilder.entity.ProfileResumeBuilder;

public class ProfileResumeBuilderPozo {
	
		private ObjectMapper mapper;

		@BeforeEach
		public void setup() {
			this.mapper = new ObjectMapper();
		}
		
		private String jsonString = "{\"firstName\":\"Amit\",\"lastName\":\"Mandal\" }";
		
		@Test
		public void employeeTest() throws JsonMappingException, JsonProcessingException {
			 ProfileResumeBuilder build = ProfileResumeBuilder.builder().firstName("Amit").lastName("Mandal").build();
			 ProfileResumeBuilder readValue = mapper.readValue(jsonString, ProfileResumeBuilder.class);
			assertEquals(build, readValue);
	}
	
}
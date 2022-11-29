package com.te.resumebuilder.pojo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.resumebuilder.entity.Education;

public class EducationPojo {
	
	private ObjectMapper mapper;

	@BeforeEach
	public void setup() {
		this.mapper = new ObjectMapper();
	}

	private String jsonString = "{\"highestEducation\":\"BE\",\"specialization\":\"Java Backened\" }";

	@Test
	public void employeeTest() throws JsonMappingException, JsonProcessingException {
		Education build = Education.builder().highestEducation("BE").specialization("Java Backened").build();
		Education readValue = mapper.readValue(jsonString, Education.class);
		assertEquals(build, readValue);
	}
}

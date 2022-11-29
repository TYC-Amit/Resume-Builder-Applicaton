package com.te.resumebuilder.pojo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.resumebuilder.entity.Skills;

public class SkillsPojo {
	
	private ObjectMapper mapper;

	@BeforeEach
	public void setup() {
		this.mapper = new ObjectMapper();
	}

	private String jsonString = "{\"frontendTechnologies\":\"Node JS\",\"backendTechnologies\":\"Spring Boot\" }";

	@Test
	public void employeeTest() throws JsonMappingException, JsonProcessingException {
		Skills build = Skills.builder().frontendTechnologies(Arrays.asList("Node Js","JavaScript")).backendTechnologies(Arrays.asList("Java")).build();
		Skills readValue = mapper.readValue(jsonString, Skills.class);
		assertEquals(build, readValue);
	}
}

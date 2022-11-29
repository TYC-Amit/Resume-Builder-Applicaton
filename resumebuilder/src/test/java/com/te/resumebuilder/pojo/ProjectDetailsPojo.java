package com.te.resumebuilder.pojo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.resumebuilder.entity.ProjectDetails;

public class ProjectDetailsPojo {

	private ObjectMapper mapper;

	@BeforeEach
	public void setup() {
		this.mapper = new ObjectMapper();
	}

	private String jsonString = "{\"duration\":\"2 years\",\"teamSize\":\"23\" }";

	@Test
	public void employeeTest() throws JsonMappingException, JsonProcessingException {
		ProjectDetails build = ProjectDetails.builder().duration("2 years").teamSize(23).build();
		ProjectDetails readValue = mapper.readValue(jsonString, ProjectDetails.class);
		assertEquals(build, readValue);
	}
}


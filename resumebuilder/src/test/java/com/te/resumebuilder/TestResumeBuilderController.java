package com.te.resumebuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.te.resumebuilder.controller.ResumeBuliderController;
import com.te.resumebuilder.dto.ResumeBuilderDto;
import com.te.resumebuilder.entity.ProfileResumeBuilder;
import com.te.resumebuilder.repo.ResumeBuilderRepo;
import com.te.resumebuilder.response.ResponseResume;
import com.te.resumebuilder.service.ResumeBuilderService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TestResumeBuilderController {

	private MockMvc mockMvc;

	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();

	@Mock
	private ResumeBuilderRepo builderRepo;

	@Mock
	private ResumeBuilderService builderService;

	private WebApplicationContext applicationContext;

	@InjectMocks
	private ResumeBuliderController resume;

	@BeforeEach
	public void setUp() {
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();//
		mockMvc = MockMvcBuilders.standaloneSetup(resume).build();
		this.objectMapper = new ObjectMapper();
	}

	@Test
	public void addResume() throws Exception {
		ProfileResumeBuilder build = ProfileResumeBuilder.builder().employeeId("TYSS09").resumeId("ghgd")
				.firstName("Amit").lastName("Mandal").build();
		ResumeBuilderDto build2 = ResumeBuilderDto.builder().employeeId("Tyss008").resumeId("bdcb").firstName("mandal")
				.build();

		when(builderService.addResume(build2)).thenReturn(build);
		
		String writeValueAsString = objectMapper.writeValueAsString(build2);
		String contentAsString = mockMvc
				.perform(post("/addResume").content(writeValueAsString)
						.contentType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		ResponseResume readValue = objectMapper.readValue(contentAsString, ResponseResume.class);
		assertEquals(false, readValue.isError());
	}

	@Test
	public void findEmployeeId() throws Exception {
		List<ProfileResumeBuilder> asList = Arrays.asList(
				ProfileResumeBuilder.builder().employeeId("TYSS09").resumeId("gshdv").firstName("amit").lastName("Mandal").build());
				
				String writeValueAsString = objectMapper.writeValueAsString(asList);
				Mockito.when(builderService.findEmployeeId(Mockito.anyString())).thenReturn(asList);
				
				String contentAsString = mockMvc
						.perform(get("/findEmployeeId").content(writeValueAsString)
								.contentType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE))
						.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//				String contentAsString2=mockMvc.perform(get("/findEmployeeId").param(contentAsString, "Tuyss09"))
//						.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
				ResponseResume readValue = objectMapper.readValue(contentAsString, ResponseResume.class);
				assertEquals(false, readValue.isError());
	}
	
	@Test
	public void findEmployeeIdAndResumeId() throws Exception {
		ProfileResumeBuilder build = ProfileResumeBuilder.builder().employeeId("TYSS09").resumeId("ghgd")
				.firstName("Amit").lastName("Mandal").build();
				String writeValueAsString = objectMapper.writeValueAsString(build);
//				Mockito.when(builderService.findEmployeeId(Mockito.anyString())).thenReturn(build);
				
//				String contentAsString = mockMvc
//						.perform(get("/findEmployeeId").content(writeValueAsString)
//								.contentType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE))
//						.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
				String contentAsString=mockMvc.perform(get("/findEmployeeIdAndResumeId").param("TYSS099","YHJFJFJ"))
						.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
				ResponseResume readValue = objectMapper.readValue(contentAsString, ResponseResume.class);
				assertEquals(false, readValue.isError());
	}
	
}

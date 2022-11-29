package com.te.resumebuilder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.resumebuilder.dto.ResumeBuilderDto;
import com.te.resumebuilder.entity.ProfileResumeBuilder;
import com.te.resumebuilder.response.ResponseResume;
import com.te.resumebuilder.service.ResumeBuilderService;

@RestController
public class ResumeBuliderController {

	@Autowired
	ResumeBuilderService builderService;

	@PostMapping("/addResume")
	public ResponseEntity<ResponseResume> addResume(@RequestBody ResumeBuilderDto builderDto) {
		System.out.println(builderDto);
		ProfileResumeBuilder addResume = builderService.addResume(builderDto);
		return new ResponseEntity<>(new ResponseResume(false, "Resume Added Successfully", addResume), HttpStatus.OK);

	}

	@GetMapping("/findEmployeeId")
	public ResponseEntity<ResponseResume> findEmployeeId(@RequestParam String employeeId) {
		List<ProfileResumeBuilder> findEmployeeId = builderService.findEmployeeId(employeeId);
		return new ResponseEntity<>(new ResponseResume(false, "Employee Find By Id", findEmployeeId), HttpStatus.OK);
	}

	@GetMapping("/findEmployeeIdAndResumeId/{employeeId}/{resumeId}")
	public ResponseEntity<ResponseResume> findEmployeeIdAndResumeId(@PathVariable("employeeId") String employeeId,
			@PathVariable("resumeId") String resumeId) {
		ProfileResumeBuilder findEmployeeIdAndResumeId = builderService.findEmployeeIdAndResumeId(employeeId, resumeId);
		return new ResponseEntity<>(new ResponseResume(false,
				"EmployeeID And ResumeId Is Present On This Particular Data", findEmployeeIdAndResumeId),
				HttpStatus.OK);

	}

}

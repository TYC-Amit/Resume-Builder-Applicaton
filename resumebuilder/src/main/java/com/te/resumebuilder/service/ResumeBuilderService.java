package com.te.resumebuilder.service;

import java.util.List;

import com.te.resumebuilder.dto.ResumeBuilderDto;
import com.te.resumebuilder.entity.ProfileResumeBuilder;

public interface ResumeBuilderService {

	ProfileResumeBuilder addResume(ResumeBuilderDto builderDto);

	public List<ProfileResumeBuilder> findEmployeeId(String employeeId);

	public ProfileResumeBuilder findEmployeeIdAndResumeId(String employeeId, String resumeId);
	
}

package com.te.resumebuilder.dto;

import java.util.List;
import com.te.resumebuilder.entity.Education;
import com.te.resumebuilder.entity.ProjectDetails;
import com.te.resumebuilder.entity.Skills;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeBuilderDto {

	private Integer profileResumeBuilderid;

	private String employeeId;

	private String resumeId;

	private String firstName;

	private String lastName;

	private String technologies;

	private String totalExperience;

	private String relativeExperience;
	
	private List<String> summary;

	private Education education;

	private Skills skills;

	private List<ProjectDetails> projectDetails;
}

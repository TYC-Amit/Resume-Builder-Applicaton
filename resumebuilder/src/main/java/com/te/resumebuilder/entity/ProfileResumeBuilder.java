package com.te.resumebuilder.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.te.resumebuilder.converter.StringListConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class ProfileResumeBuilder implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer profileResumeBuilderid;

	private String employeeId;

	private String resumeId;

	private String firstName;

	private String lastName;

	private String technologies;

	private String totalExperience;

	private String relativeExperience;

	@Convert(converter = StringListConverter.class)
	private List<String> summary;

	@OneToOne(cascade = CascadeType.ALL)
	private Education education;

	@OneToOne(cascade = CascadeType.ALL)
	private Skills skills;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "profileResumeBuilderid")
	private List<ProjectDetails> projectDetails;

}

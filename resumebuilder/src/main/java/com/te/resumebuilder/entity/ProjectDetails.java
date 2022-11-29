package com.te.resumebuilder.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.te.resumebuilder.converter.StringListConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProjectDetails implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectDetailsId;

	@Convert(converter = StringListConverter.class)
	private List<String> frontendTechnologies;

	@Convert(converter = StringListConverter.class)
	private List<String> backendTechnologies;

	@Convert(converter = StringListConverter.class)
	private List<String> designPatterns;

	@Convert(converter = StringListConverter.class)
	private List<String> databaseUsed;

	@Convert(converter = StringListConverter.class)
	private List<String> developmentTools;

	private String duration;

	private Integer teamSize;

	private String projectDescription;

	private String roleAndResponsibility;
}

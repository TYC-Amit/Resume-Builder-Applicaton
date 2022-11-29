package com.te.resumebuilder.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.resumebuilder.entity.ProfileResumeBuilder;

@Repository
public interface ResumeBuilderRepo extends JpaRepository<ProfileResumeBuilder, Integer>{

	List<ProfileResumeBuilder> findAllByEmployeeId(String employeeId);
	
	ProfileResumeBuilder findByEmployeeIdAndResumeId(String employeeId,String resumeId);

	List<ProfileResumeBuilder> save(Optional<ProfileResumeBuilder> findById);
}

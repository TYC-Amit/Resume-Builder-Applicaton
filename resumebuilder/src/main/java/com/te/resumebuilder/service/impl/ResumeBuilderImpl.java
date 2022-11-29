package com.te.resumebuilder.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.resumebuilder.dto.ResumeBuilderDto;
import com.te.resumebuilder.entity.ProfileResumeBuilder;
import com.te.resumebuilder.excption.ResumeBuilderNotFoundException;
import com.te.resumebuilder.repo.ResumeBuilderRepo;
import com.te.resumebuilder.service.ResumeBuilderService;

@Service
public class ResumeBuilderImpl implements ResumeBuilderService {

	@Autowired
	ResumeBuilderRepo builderRepo;

	@Override
	public ProfileResumeBuilder addResume(ResumeBuilderDto builderDto) {
		try {
			ProfileResumeBuilder builderfirst = new ProfileResumeBuilder();
			BeanUtils.copyProperties(builderDto, builderfirst);
			if (builderDto == null) {
				throw new ResumeBuilderNotFoundException("Resume Is Not Found");
			} else {
				List<ProfileResumeBuilder> list = builderRepo.findAllByEmployeeId(builderfirst.getEmployeeId());
				builderfirst.setResumeId("Res_" + builderDto.getTotalExperience() + "_" + (list.size() + 1));
			}
			return builderRepo.save(builderfirst);

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<ProfileResumeBuilder> findEmployeeId(String employeeId) {
		List<ProfileResumeBuilder> findAllByEmployeeId = builderRepo.findAllByEmployeeId(employeeId);
		try {
			if (findAllByEmployeeId.isEmpty()) {
				throw new ResumeBuilderNotFoundException("Please Enter Proper EmployeeId");
			}
		} catch (Exception e) {
			throw e;
		}
		return findAllByEmployeeId;
	}

	@Override
	public ProfileResumeBuilder findEmployeeIdAndResumeId(String employeeId, String resumeId) {
		ProfileResumeBuilder findByEmployeeIdAndResumeId = builderRepo.findByEmployeeIdAndResumeId(employeeId,
				resumeId);
		try {
			if (resumeId.isEmpty() && employeeId.isEmpty()) {
				throw new ResumeBuilderNotFoundException(
						"Employee Id And The Resume Id Is Not Match With The Database");
			}
		} catch (Exception e) {
			throw e;
		}
		return findByEmployeeIdAndResumeId;
	}

}

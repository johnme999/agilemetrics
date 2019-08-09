package com.awsomeday.agilemetricsjs3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.awsomeday.agilemetricsjs3.domain.Sprint;
import com.awsomeday.agilemetricsjs3.repository.SprintRepository;

@RestController
public class SprintController {

	@Autowired
	SprintRepository sprintRepository;
	
	@RequestMapping(value = "/sprintdatabyprojectname/{projectName}", method = RequestMethod.GET, produces = "application/json")
	public List<Sprint> fetchSprintDetailsByProjectName(@PathVariable String projectName) {
//		List<Sprint> sprintData = sprintRepository.findByProjectName(projectName);
//		for (Sprint sprint : sprintData) {
//			System.out.println(sprint.getName());
//		}
//		return sprintData;
		return null;
	}
}

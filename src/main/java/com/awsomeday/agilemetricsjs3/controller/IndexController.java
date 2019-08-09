package com.awsomeday.agilemetricsjs3.controller;

import com.awsomeday.agilemetricsjs3.domain.Sprint;
import com.awsomeday.agilemetricsjs3.domain.StoryPointMapping;
import com.awsomeday.agilemetricsjs3.repository.PriorityDetailsRepository;
import com.awsomeday.agilemetricsjs3.repository.SprintRepository;
import com.awsomeday.agilemetricsjs3.repository.StoryPointMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    SprintRepository sprintRepository;

    @Autowired
    StoryPointMappingRepository storyPointMappingRepository;

    @Autowired
    PriorityDetailsRepository priorityDetailsRepository;

    @GetMapping("/")
    public String getSprintDetails(Model model) {
        List<StoryPointMapping> sprintStoryPointData = storyPointMappingRepository.findAll();
        List<String> sprintName = new ArrayList<>();
        List<Integer> sprintVelocity = new ArrayList<>();
        List<Integer> sprintVelocityPredictability = new ArrayList<>();
        List<Integer> sprintSuccessRate = new ArrayList<>();
        List<Integer> sprintVelocityCommitted = new ArrayList<>();
        List<Integer> sprintAddedWork = new ArrayList<>();
        for (StoryPointMapping sprint : sprintStoryPointData) {
            sprintName.add(sprint.getSprintName());
            sprintVelocity.add(sprint.getAcceptedStoryPoint());
            sprintVelocityPredictability.add(calculateVP(sprint));
            sprintSuccessRate.add(calculateSuccessRate(sprint));
            sprintVelocityCommitted.add(sprint.getCommittedStoryPoint());
            sprintAddedWork.add(calculateScope(sprint));
        }
        model.addAttribute("sprintNameForVelocityChart", sprintName);
        model.addAttribute("sprintVelocity", sprintVelocity);
        model.addAttribute("sprintVelocityPredictability", sprintVelocityPredictability);
        model.addAttribute("sprintSuccessRate", sprintSuccessRate);
        model.addAttribute("sprintVelocityCommitted", sprintVelocityCommitted);
        model.addAttribute("sprintAddedWork", sprintAddedWork);

        return "dashboard";
    }

    private int calculateVP(StoryPointMapping storyPointMapping) {
        int diff = storyPointMapping.getAcceptedStoryPoint() - storyPointMapping.getCommittedStoryPoint();
        float div =  (float) diff/ (float) storyPointMapping.getCommittedStoryPoint();
        return Math.round(div * 100);
    }

    private int calculateSuccessRate(StoryPointMapping storyPointMapping) {
        float div =  (float) storyPointMapping.getAcceptedStoryPoint() / (float) storyPointMapping.getCommittedStoryPoint();
        return Math.round(div * 100);
    }

    private int calculateScope(StoryPointMapping storyPointMapping) {
        return   storyPointMapping.getAcceptedStoryPoint() - storyPointMapping.getCommittedStoryPoint();
    }
}
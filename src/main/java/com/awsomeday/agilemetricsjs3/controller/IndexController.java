package com.awsomeday.agilemetricsjs3.controller;

import com.awsomeday.agilemetricsjs3.domain.PriorityDetails;
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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
        List<PriorityDetails> priorityDetailsData = priorityDetailsRepository.findAll();
        List<String> sprintName = new ArrayList<>();
        List<Integer> sprintVelocity = new ArrayList<>();
        List<Integer> sprintVelocityPredictability = new ArrayList<>();
        List<Integer> sprintSuccessRate = new ArrayList<>();
        List<Integer> sprintVelocityCommitted = new ArrayList<>();
        List<Integer> sprintAddedWork = new ArrayList<>();
        Set<String> sprintNamePriorityList = getSprintNameOfPriority(priorityDetailsData);
        List<Integer> lowest = new ArrayList<>();
        List<Integer> high = new ArrayList<>();
        List<Integer> low = new ArrayList<>();
        List<Integer> medium = new ArrayList<>();
        List<Integer> highest = new ArrayList<>();
        for (StoryPointMapping sprint : sprintStoryPointData) {
            sprintName.add(sprint.getSprintName());
            sprintVelocity.add(sprint.getAcceptedStoryPoint());
            sprintVelocityPredictability.add(calculateVP(sprint));
            sprintSuccessRate.add(calculateSuccessRate(sprint));
            sprintVelocityCommitted.add(sprint.getCommittedStoryPoint());
            sprintAddedWork.add(calculateScope(sprint));
        }
        for (String sprintNamePriority:sprintNamePriorityList) {
            lowest.add(getLowest(priorityDetailsData, sprintNamePriority));
            high.add(getHigh(priorityDetailsData, sprintNamePriority));
            low.add(getLow(priorityDetailsData, sprintNamePriority));
            medium.add(getMedium(priorityDetailsData, sprintNamePriority));
            highest.add(getHighest(priorityDetailsData, sprintNamePriority));
        }
        model.addAttribute("sprintNameForVelocityChart", sprintName);
        model.addAttribute("sprintVelocity", sprintVelocity);
        model.addAttribute("sprintVelocityPredictability", sprintVelocityPredictability);
        model.addAttribute("sprintSuccessRate", sprintSuccessRate);
        model.addAttribute("sprintVelocityCommitted", sprintVelocityCommitted);
        model.addAttribute("sprintAddedWork", sprintAddedWork);
        model.addAttribute("sprintNameForPriorityChart", sprintNamePriorityList);
        model.addAttribute("lowest", lowest);
        model.addAttribute("high", high);
        model.addAttribute("low", low);
        model.addAttribute("medium", medium);
        model.addAttribute("highest", highest);
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

    private Set<String> getSprintNameOfPriority(List<PriorityDetails> priorityDetailsList) {
        List<String> sprintName = new ArrayList<>();
        for (PriorityDetails priorityDetails1: priorityDetailsList) {
            sprintName.add(priorityDetails1.getSprintName());
        }
        return new LinkedHashSet<String>(sprintName);
    }

    private Integer getHighest(List<PriorityDetails> priorityDetailsData, String sprintNamePriority) {
        int highest = 0;
        for (PriorityDetails priorityDetails : priorityDetailsData) {
            if (sprintNamePriority.equalsIgnoreCase(priorityDetails.getSprintName()) && "Highest".equalsIgnoreCase(priorityDetails.getPriority())) {
                highest += priorityDetails.getPriorityCount();
            }
        }
        return highest;
    }

    private Integer getMedium(List<PriorityDetails> priorityDetailsData, String sprintNamePriority) {
        int medium = 0;
        for (PriorityDetails priorityDetails : priorityDetailsData) {
            if (sprintNamePriority.equalsIgnoreCase(priorityDetails.getSprintName()) && "Medium".equalsIgnoreCase(priorityDetails.getPriority())) {
                medium += priorityDetails.getPriorityCount();
            }
        }
        return medium;
    }

    private Integer getLow(List<PriorityDetails> priorityDetailsData, String sprintNamePriority) {
        int low = 0;
        for (PriorityDetails priorityDetails : priorityDetailsData) {
            if (sprintNamePriority.equalsIgnoreCase(priorityDetails.getSprintName()) && "Low".equalsIgnoreCase(priorityDetails.getPriority())) {
                low += priorityDetails.getPriorityCount();
            }
        }
        return low;
    }

    private Integer getHigh(List<PriorityDetails> priorityDetailsData, String sprintNamePriority) {
        int high = 0;
        for (PriorityDetails priorityDetails : priorityDetailsData) {
            if (sprintNamePriority.equalsIgnoreCase(priorityDetails.getSprintName()) && "High".equalsIgnoreCase(priorityDetails.getPriority())) {
                high += priorityDetails.getPriorityCount();
            }
        }
        return high;
    }

    private Integer getLowest(List<PriorityDetails> priorityDetailsData, String sprintNamePriority) {
        int lowest = 0;
        for (PriorityDetails priorityDetails : priorityDetailsData) {
            if (sprintNamePriority.equalsIgnoreCase(priorityDetails.getSprintName()) && "Lowest".equalsIgnoreCase(priorityDetails.getPriority())) {
                lowest += priorityDetails.getPriorityCount();
            }
        }
        return lowest;
    }
}
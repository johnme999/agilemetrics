package com.awsomeday.agilemetricsjs3.domain;

import javax.persistence.*;

@Entity
@Table(name = "PRIORITYDETAILS")
public class PriorityDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "PROJECTNAME")
    private String projectName;

    @Column(name = "SPRINTNAME")
    private String sprintName;

    @Column(name = "ISSUETYPE")
    private String issueType;

    @Column(name = "PRIORITY")
    private String priority;

    @Column(name = "PRIORITYCOUNT")
    private int priorityCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getPriorityCount() {
        return priorityCount;
    }

    public void setPriorityCount(int priorityCount) {
        this.priorityCount = priorityCount;
    }
}

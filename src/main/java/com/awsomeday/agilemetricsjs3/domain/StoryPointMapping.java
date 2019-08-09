package com.awsomeday.agilemetricsjs3.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STORYPOINTMAPPING")
public class StoryPointMapping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "PROJECTNAME")
    private String projectName;

    @Column(name = "SPRINTNAME")
    private String sprintName;

    @Column(name = "COMMITTEDSP")
    private int committedStoryPoint;

    @Column(name = "ACCEPTEDSP")
    private int acceptedStoryPoint;

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

    public int getCommittedStoryPoint() {
        return committedStoryPoint;
    }

    public void setCommittedStoryPoint(int committedStoryPoint) {
        this.committedStoryPoint = committedStoryPoint;
    }

    public int getAcceptedStoryPoint() {
        return acceptedStoryPoint;
    }

    public void setAcceptedStoryPoint(int acceptedStoryPoint) {
        this.acceptedStoryPoint = acceptedStoryPoint;
    }
}

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
    private int priority;

    @Column(name = "PRIORITYCOUNT")
    private int priorityCount;
}

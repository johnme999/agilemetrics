package com.awsomeday.agilemetricsjs3.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SPRINT")
public class Sprint implements Serializable {

	private static final long serialVersionUID = -2758109401297584619L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PROJECTNAME")
	private String projectName;
	
	@Column(name = "STARTDATE")
	private String startDate;
	
	@Column(name = "ENDDATE")
	private String endDate;
	
	@Column(name = "CLOSED")
	private boolean isClosed;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public boolean isClosed() {
		return isClosed;
	}

	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}	
	
}

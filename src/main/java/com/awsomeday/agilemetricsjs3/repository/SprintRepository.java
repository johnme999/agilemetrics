package com.awsomeday.agilemetricsjs3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.awsomeday.agilemetricsjs3.domain.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {
	
	List<Sprint> findByProjectName(String projectName);

}

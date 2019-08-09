package com.awsomeday.agilemetricsjs3.repository;

import com.awsomeday.agilemetricsjs3.domain.PriorityDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityDetailsRepository extends JpaRepository<PriorityDetails, Long> {

}

package com.awsomeday.agilemetricsjs3.repository;

import com.awsomeday.agilemetricsjs3.domain.StoryPointMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryPointMappingRepository extends JpaRepository<StoryPointMapping, Long> {
}

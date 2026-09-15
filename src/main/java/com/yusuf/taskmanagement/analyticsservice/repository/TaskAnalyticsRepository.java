package com.yusuf.taskmanagement.analyticsservice.repository;

import com.yusuf.taskmanagement.analyticsservice.domain.TaskAnalytics;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskAnalyticsRepository
        extends MongoRepository<TaskAnalytics, String> {

    long countByDeletedFalse();

    long countByDeletedTrue();

    long countByStatusAndDeletedFalse(String status);
}
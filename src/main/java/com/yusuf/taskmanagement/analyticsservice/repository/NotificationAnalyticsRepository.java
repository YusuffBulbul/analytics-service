package com.yusuf.taskmanagement.analyticsservice.repository;

import com.yusuf.taskmanagement.analyticsservice.domain.NotificationAnalytics;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationAnalyticsRepository
        extends MongoRepository<NotificationAnalytics, String> {
}
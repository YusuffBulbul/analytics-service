package com.yusuf.taskmanagement.analyticsservice.service;

import com.yusuf.taskmanagement.analyticsservice.domain.NotificationAnalytics;
import com.yusuf.taskmanagement.analyticsservice.domain.TaskAnalytics;
import com.yusuf.taskmanagement.analyticsservice.event.NotificationEvent;
import com.yusuf.taskmanagement.analyticsservice.event.TaskEvent;
import com.yusuf.taskmanagement.analyticsservice.repository.NotificationAnalyticsRepository;
import com.yusuf.taskmanagement.analyticsservice.repository.TaskAnalyticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticsEventService {

    private final TaskAnalyticsRepository taskAnalyticsRepository;
    private final NotificationAnalyticsRepository notificationAnalyticsRepository;

    public void processTaskEvent(TaskEvent event) {
        TaskAnalytics analytics = taskAnalyticsRepository
                .findById(event.taskId())
                .orElseGet(() -> TaskAnalytics.builder()
                        .taskId(event.taskId())
                        .build());

        analytics.setUserId(event.userId());
        analytics.setTitle(event.title());
        analytics.setStatus(event.status());
        analytics.setLastEventType(event.eventType());
        analytics.setOccurredAt(event.occurredAt());
        analytics.setDeleted("TASK_DELETED".equals(event.eventType()));

        taskAnalyticsRepository.save(analytics);
    }

    public void processNotificationEvent(NotificationEvent event) {
        NotificationAnalytics analytics = NotificationAnalytics.builder()
                .notificationId(event.notificationId())
                .eventId(event.eventId())
                .taskId(event.taskId())
                .userId(event.userId())
                .message(event.message())
                .occurredAt(event.occurredAt())
                .build();

        notificationAnalyticsRepository.save(analytics);
    }
}
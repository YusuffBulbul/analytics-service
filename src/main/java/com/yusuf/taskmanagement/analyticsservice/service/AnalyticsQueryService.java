package com.yusuf.taskmanagement.analyticsservice.service;

import com.yusuf.taskmanagement.analyticsservice.dto.AnalyticsSummaryResponse;
import com.yusuf.taskmanagement.analyticsservice.repository.NotificationAnalyticsRepository;
import com.yusuf.taskmanagement.analyticsservice.repository.TaskAnalyticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticsQueryService {

    private final TaskAnalyticsRepository taskAnalyticsRepository;
    private final NotificationAnalyticsRepository notificationAnalyticsRepository;

    public AnalyticsSummaryResponse getSummary() {
        long totalTasks = taskAnalyticsRepository.count();
        long activeTasks = taskAnalyticsRepository.countByDeletedFalse();
        long deletedTasks = taskAnalyticsRepository.countByDeletedTrue();

        long todoTasks =
                taskAnalyticsRepository.countByStatusAndDeletedFalse("TODO");

        long inProgressTasks =
                taskAnalyticsRepository.countByStatusAndDeletedFalse(
                        "IN_PROGRESS"
                );

        long completedTasks =
                taskAnalyticsRepository.countByStatusAndDeletedFalse(
                        "COMPLETED"
                );

        long totalNotifications = notificationAnalyticsRepository.count();

        return new AnalyticsSummaryResponse(
                totalTasks,
                activeTasks,
                deletedTasks,
                todoTasks,
                inProgressTasks,
                completedTasks,
                totalNotifications
        );
    }
}
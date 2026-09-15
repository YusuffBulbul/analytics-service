package com.yusuf.taskmanagement.analyticsservice.dto;

public record AnalyticsSummaryResponse(
        long totalTasks,
        long activeTasks,
        long deletedTasks,
        long todoTasks,
        long inProgressTasks,
        long completedTasks,
        long totalNotifications
) {
}
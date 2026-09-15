package com.yusuf.taskmanagement.analyticsservice.event;

import java.time.Instant;

public record TaskEvent(
        String eventId,
        String eventType,
        Instant occurredAt,
        String taskId,
        String userId,
        String title,
        String status
) {
}
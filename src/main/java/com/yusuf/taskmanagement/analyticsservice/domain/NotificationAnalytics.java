package com.yusuf.taskmanagement.analyticsservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notification_analytics")
public class NotificationAnalytics {

    @Id
    private String notificationId;

    private String eventId;
    private String taskId;
    private String userId;
    private String message;
    private Instant occurredAt;
}
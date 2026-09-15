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
@Document(collection = "task_analytics")
public class TaskAnalytics {

    @Id
    private String taskId;

    private String userId;
    private String title;
    private String status;
    private String lastEventType;
    private Instant occurredAt;
    private boolean deleted;
}
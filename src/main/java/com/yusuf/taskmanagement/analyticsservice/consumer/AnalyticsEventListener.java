package com.yusuf.taskmanagement.analyticsservice.consumer;

import com.yusuf.taskmanagement.analyticsservice.event.NotificationEvent;
import com.yusuf.taskmanagement.analyticsservice.event.TaskEvent;
import com.yusuf.taskmanagement.analyticsservice.service.AnalyticsEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class AnalyticsEventListener {

    private final ObjectMapper objectMapper;
    private final AnalyticsEventService analyticsEventService;

    @KafkaListener(
            topics = "task-events",
            groupId = "analytics-task-group"
    )
    public void consumeTaskEvent(String message) {
        TaskEvent event = objectMapper.readValue(message, TaskEvent.class);

        analyticsEventService.processTaskEvent(event);

        log.info(
                "Task eventi analiz edildi. taskId={}, eventType={}",
                event.taskId(),
                event.eventType()
        );
    }

    @KafkaListener(
            topics = "notification-events",
            groupId = "analytics-notification-group"
    )
    public void consumeNotificationEvent(String message) {
        NotificationEvent event =
                objectMapper.readValue(message, NotificationEvent.class);

        analyticsEventService.processNotificationEvent(event);

        log.info(
                "Notification eventi analiz edildi. notificationId={}",
                event.notificationId()
        );
    }
}
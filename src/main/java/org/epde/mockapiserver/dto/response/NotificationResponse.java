package org.epde.mockapiserver.dto.response;

public record NotificationResponse(int notificationId, String message, String status) {
}
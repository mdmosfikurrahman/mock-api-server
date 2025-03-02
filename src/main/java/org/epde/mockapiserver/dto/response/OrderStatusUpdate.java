package org.epde.mockapiserver.dto.response;

public record OrderStatusUpdate(String orderId, String newStatus) {
}

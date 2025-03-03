package org.epde.mockapiserver.dto.response;

public record OrderHistoryResponse(String orderId, String status, String date) {
}
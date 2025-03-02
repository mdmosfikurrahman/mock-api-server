package org.epde.mockapiserver.dto.response;

import java.util.List;

public record OrderResponse(String orderId, String status, List<String> items) {
}


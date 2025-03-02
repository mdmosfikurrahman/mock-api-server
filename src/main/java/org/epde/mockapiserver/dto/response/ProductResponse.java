package org.epde.mockapiserver.dto.response;

public record ProductResponse(int id, String name, double price, boolean available) {
}

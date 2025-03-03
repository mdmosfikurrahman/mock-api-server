package org.epde.mockapiserver.dto.request;

public record ProductCatalogRequest(String category, double minPrice, double maxPrice, boolean availableOnly) {
}
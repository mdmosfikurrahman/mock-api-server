
package org.epde.mockapiserver.dto.response;

public record ProductCatalogResponse(
        int id, String name, double price, boolean available, double rating,
        ProductSpecificationResponse specifications
) {
}
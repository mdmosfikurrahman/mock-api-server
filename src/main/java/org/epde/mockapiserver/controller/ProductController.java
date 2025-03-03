package org.epde.mockapiserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.epde.mockapiserver.dto.request.ProductCatalogRequest;
import org.epde.mockapiserver.dto.request.ProductRecommendationRequest;
import org.epde.mockapiserver.dto.response.ProductCatalogResponse;
import org.epde.mockapiserver.dto.response.ProductRecommendationResponse;
import org.epde.mockapiserver.dto.response.ProductResponse;
import org.epde.mockapiserver.service.MockApiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Product APIs", description = "Endpoints for managing products")
public class ProductController {

    private final MockApiService mockApiService;

    @Operation(summary = "Get Products", description = "Retrieve all available products")
    @GetMapping
    public List<ProductResponse> getProducts() {
        return mockApiService.getProducts();
    }

    @Operation(summary = "Get Product Details", description = "Retrieve product details based on name and optional price")
    @GetMapping("/details")
    public ProductResponse getProductDetails(@RequestParam String name, @RequestParam(required = false, defaultValue = "0") double price) {
        return mockApiService.getProductDetails(name, price);
    }

    @Operation(summary = "Get Product Recommendations", description = "Retrieve product recommendations based request body")
    @GetMapping("/recommendations")
    public List<ProductRecommendationResponse> getRecommendations(@RequestBody ProductRecommendationRequest request) {
        return mockApiService.getRecommendations(request);
    }

    @Operation(summary = "Get Product Catalog", description = "Retrieve product catalog based request body")
    @PostMapping("/catalog")
    public List<ProductCatalogResponse> getProductCatalog(@RequestBody ProductCatalogRequest request) {
        return mockApiService.getProductCatalog(request);
    }

}

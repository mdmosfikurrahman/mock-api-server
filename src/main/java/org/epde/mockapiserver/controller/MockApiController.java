package org.epde.mockapiserver.controller;

import lombok.RequiredArgsConstructor;
import org.epde.mockapiserver.dto.request.*;
import org.epde.mockapiserver.dto.response.*;
import org.epde.mockapiserver.service.MockApiService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mock-api")
public class MockApiController {

    private final MockApiService mockApiService;

    @GetMapping("/user")
    public UserResponse getUser() {
        return mockApiService.getUser();
    }

    @GetMapping("/user/{id}")
    public UserResponse getUserById(@PathVariable int id) {
        return mockApiService.getUserById(id);
    }

    @PutMapping("/user/{id}")
    public UserResponse updateUser(@PathVariable int id, @RequestBody UserRequest userRequest) {
        return mockApiService.updateUser(id, userRequest);
    }

    @GetMapping("/products")
    public List<ProductResponse> getProducts() {
        return mockApiService.getProducts();
    }

    @GetMapping("/product/details")
    public ProductResponse getProductDetails(@RequestParam String name, @RequestParam(required = false, defaultValue = "0") double price) {
        return mockApiService.getProductDetails(name, price);
    }

    @PostMapping("/order")
    public OrderResponse placeOrder(@RequestBody OrderRequest orderRequest) {
        return mockApiService.placeOrder(orderRequest);
    }

    @DeleteMapping("/order/{orderId}")
    public DeleteOrderResponse deleteOrder(@PathVariable String orderId) {
        return mockApiService.deleteOrder(orderId);
    }

    @PatchMapping("/order/{orderId}/status")
    public OrderStatusUpdate updateOrderStatus(@PathVariable String orderId, @RequestParam String status) {
        return mockApiService.updateOrderStatus(orderId, status);
    }

    @GetMapping("/status")
    public ApiStatusResponse getApiStatus() {
        return mockApiService.getApiStatus();
    }

    @GetMapping("/user/details")
    public UserDetailsResponse getUserDetails(@RequestBody UserDetailsRequest request) {
        return mockApiService.getUserDetails(request);
    }

    @GetMapping("/orders/history")
    public List<OrderHistoryResponse> getOrderHistory(@RequestBody OrderHistoryRequest request) {
        return mockApiService.getOrderHistory(request);
    }

    @GetMapping("/products/recommendations")
    public List<ProductRecommendationResponse> getRecommendations(@RequestBody ProductRecommendationRequest request) {
        return mockApiService.getRecommendations(request);
    }

    @PostMapping("/user/dashboard")
    public UserDashboardResponse getUserDashboard(@RequestBody UserDashboardRequest request) {
        return mockApiService.getUserDashboard(request);
    }

    @PostMapping("/products/catalog")
    public List<ProductCatalogResponse> getProductCatalog(@RequestBody ProductCatalogRequest request) {
        return mockApiService.getProductCatalog(request);
    }

}

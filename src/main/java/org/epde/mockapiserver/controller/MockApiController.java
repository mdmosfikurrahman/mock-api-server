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
    public String deleteOrder(@PathVariable String orderId) {
        return mockApiService.deleteOrder(orderId);
    }

    @PatchMapping("/order/{orderId}/status")
    public OrderStatusUpdate updateOrderStatus(@PathVariable String orderId, @RequestParam String status) {
        return mockApiService.updateOrderStatus(orderId, status);
    }

    @GetMapping("/status")
    public String getApiStatus() {
        return mockApiService.getApiStatus();
    }

    @GetMapping("/user/details")
    public Map<String, Object> getUserDetails(@RequestBody Map<String, Object> request) {
        Map<String, Object> user = new HashMap<>();
        user.put("id", request.getOrDefault("id", 0));
        user.put("name", request.getOrDefault("name", "Unknown"));
        user.put("email", request.getOrDefault("email", "unknown@example.com"));
        return user;
    }

    @GetMapping("/orders/history")
    public List<Map<String, Object>> getOrderHistory(@RequestBody Map<String, Object> filters) {
        List<Map<String, Object>> orders = new ArrayList<>();

        Map<String, Object> order = new HashMap<>();
        order.put("orderId", UUID.randomUUID().toString());
        order.put("status", filters.getOrDefault("status", "Processing"));
        order.put("date", filters.getOrDefault("date", "2025-02-25"));

        orders.add(order);
        return orders;
    }

    @GetMapping("/products/recommendations")
    public List<Map<String, Object>> getRecommendations(@RequestBody Map<String, Object> preferences) {
        List<Map<String, Object>> products = new ArrayList<>();

        Map<String, Object> product = new HashMap<>();
        product.put("name", preferences.getOrDefault("category", "Electronics"));
        product.put("price", 299.99);
        product.put("rating", 4.5);

        products.add(product);
        return products;
    }

    @PostMapping("/user/dashboard")
    public Map<String, Object> getUserDashboard(@RequestBody Map<String, Object> request) {
        int userId = (int) request.getOrDefault("userId", 0);
        String name = (String) request.getOrDefault("name", "Guest User");
        String email = (String) request.getOrDefault("email", "guest@example.com");

        Map<String, Object> response = new HashMap<>();

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("id", userId);
        userInfo.put("name", name);
        userInfo.put("email", email);

        List<Map<String, Object>> activities = Arrays.asList(
                Map.of("activityId", 1, "description", "Logged in", "timestamp", "2025-02-25T10:00"),
                Map.of("activityId", 2, "description", "Viewed dashboard", "timestamp", "2025-02-25T10:05"),
                Map.of("activityId", 3, "description", "Checked notifications", "timestamp", "2025-02-25T10:10")
        );

        List<Map<String, Object>> notifications = Arrays.asList(
                Map.of("notificationId", 1, "message", "Welcome to our platform!", "status", "Unread"),
                Map.of("notificationId", 2, "message", "Your order has been shipped.", "status", "Unread"),
                Map.of("notificationId", 3, "message", "New promotional offer available!", "status", "Read")
        );

        response.put("userInfo", userInfo);
        response.put("recentActivities", activities);
        response.put("notifications", notifications);

        return response;
    }

    @PostMapping("/products/catalog")
    public Map<String, Object> getProductCatalog(@RequestBody Map<String, Object> filters) {
        String category = (String) filters.getOrDefault("category", "All");
        double minPrice = filters.containsKey("minPrice") ? ((Number) filters.get("minPrice")).doubleValue() : 0.0;
        double maxPrice = filters.containsKey("maxPrice") ? ((Number) filters.get("maxPrice")).doubleValue() : 1000.0;
        boolean availableOnly = (boolean) filters.getOrDefault("availableOnly", true);

        Map<String, Object> response = new HashMap<>();
        response.put("category", category);
        response.put("minPrice", minPrice);
        response.put("maxPrice", maxPrice);
        response.put("availableOnly", availableOnly);

        List<Map<String, Object>> products = Arrays.asList(
                Map.of(
                        "id", 101, "name", category + " Laptop", "price", 799.99, "available", availableOnly, "rating", 4.5,
                        "specifications", Map.of("brand", "Brand A", "color", "Black", "warranty", "1 Year")
                ),
                Map.of(
                        "id", 102, "name", category + " Smartphone", "price", 499.99, "available", availableOnly, "rating", 4.3,
                        "specifications", Map.of("brand", "Brand B", "color", "White", "warranty", "2 Years")
                ),
                Map.of(
                        "id", 103, "name", category + " Tablet", "price", 299.99, "available", availableOnly, "rating", 4.1,
                        "specifications", Map.of("brand", "Brand C", "color", "Silver", "warranty", "6 Months")
                )
        );

        response.put("products", products);
        response.put("totalProducts", products.size());

        return response;
    }



}



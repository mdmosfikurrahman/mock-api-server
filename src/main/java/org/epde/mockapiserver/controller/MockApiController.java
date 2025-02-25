package org.epde.mockapiserver.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/mockapi")
public class MockApiController {

    @GetMapping("/user")
    public Map<String, Object> getUser() {
        Map<String, Object> user = new HashMap<>();
        user.put("id", 1);
        user.put("name", "John Doe");
        user.put("email", "johndoe@example.com");
        return user;
    }

    @GetMapping("/user/{id}")
    public Map<String, Object> getUserById(@PathVariable int id) {
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("name", "User " + id);
        user.put("email", "user" + id + "@example.com");
        return user;
    }

    @GetMapping("/product/details")
    public Map<String, Object> getProductDetails(@RequestParam String name, @RequestParam(required = false, defaultValue = "0") double price) {
        Map<String, Object> product = new HashMap<>();
        product.put("name", name);
        product.put("price", price);
        product.put("available", true);
        return product;
    }

    @GetMapping("/products")
    public List<Map<String, Object>> getProducts() {
        List<Map<String, Object>> products = new ArrayList<>();

        Map<String, Object> product1 = new HashMap<>();
        product1.put("id", 101);
        product1.put("name", "Laptop");
        product1.put("price", 799.99);

        Map<String, Object> product2 = new HashMap<>();
        product2.put("id", 102);
        product2.put("name", "Smartphone");
        product2.put("price", 499.99);

        products.add(product1);
        products.add(product2);

        return products;
    }

    @PostMapping("/order")
    public Map<String, Object> placeOrder(@RequestBody Map<String, Object> orderRequest) {
        Map<String, Object> response = new HashMap<>();
        response.put("orderId", UUID.randomUUID().toString());
        response.put("status", "Order Placed Successfully");
        response.put("items", orderRequest.get("items"));
        return response;
    }

    @PutMapping("/user/{id}")
    public Map<String, Object> updateUser(@PathVariable int id, @RequestBody Map<String, Object> userUpdate) {
        Map<String, Object> updatedUser = new HashMap<>();
        updatedUser.put("id", id);
        updatedUser.put("name", userUpdate.getOrDefault("name", "Updated User"));
        updatedUser.put("email", userUpdate.getOrDefault("email", "updated@example.com"));
        return updatedUser;
    }

    @DeleteMapping("/order/{orderId}")
    public Map<String, Object> deleteOrder(@PathVariable String orderId) {
        Map<String, Object> response = new HashMap<>();
        response.put("orderId", orderId);
        response.put("status", "Order Deleted Successfully");
        return response;
    }

    @PatchMapping("/order/{orderId}/status")
    public Map<String, Object> updateOrderStatus(@PathVariable String orderId, @RequestParam String status) {
        Map<String, Object> response = new HashMap<>();
        response.put("orderId", orderId);
        response.put("newStatus", status);
        return response;
    }

    @GetMapping("/status")
    public Map<String, String> getStatus() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "API is running smoothly");
        return status;
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

        Map<String, Object> response = new HashMap<>();

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("id", userId);
        userInfo.put("name", request.getOrDefault("name", "Guest User"));
        userInfo.put("email", request.getOrDefault("email", "guest@example.com"));

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
        double minPrice = (double) filters.getOrDefault("minPrice", 0.0);
        double maxPrice = (double) filters.getOrDefault("maxPrice", 1000.0);
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



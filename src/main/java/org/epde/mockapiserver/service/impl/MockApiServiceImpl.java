package org.epde.mockapiserver.service.impl;

import org.epde.mockapiserver.dto.request.*;
import org.epde.mockapiserver.dto.response.*;
import org.epde.mockapiserver.service.MockApiService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MockApiServiceImpl implements MockApiService {

    @Override
    public UserResponse getUser() {
        return new UserResponse(1, "John Doe", "johndoe@example.com");
    }

    @Override
    public UserResponse getUserById(int id) {
        return new UserResponse(id, "User " + id, "user" + id + "@example.com");
    }

    @Override
    public UserResponse updateUser(int id, UserRequest userRequest) {
        return new UserResponse(
                id,
                userRequest.name() != null ? userRequest.name() : "Updated User",
                userRequest.email() != null ? userRequest.email() : "updated@example.com"
        );
    }

    @Override
    public List<ProductResponse> getProducts() {
        return Arrays.asList(
                new ProductResponse(101, "Laptop", 799.99, true),
                new ProductResponse(102, "Smartphone", 499.99, true)
        );
    }

    @Override
    public ProductResponse getProductDetails(String name, double price) {
        return new ProductResponse(201, name, price, true);
    }

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        return new OrderResponse(UUID.randomUUID().toString(), "Order Placed Successfully", orderRequest.items());
    }

    @Override
    public OrderStatusUpdate updateOrderStatus(String orderId, String status) {
        return new OrderStatusUpdate(orderId, status);
    }

    @Override
    public DeleteOrderResponse deleteOrder(String orderId) {
        return new DeleteOrderResponse(orderId, "Order with ID " + orderId + " has been deleted successfully.");
    }

    @Override
    public ApiStatusResponse getApiStatus() {
        return new ApiStatusResponse("API is running smoothly");
    }

    @Override
    public UserDetailsResponse getUserDetails(UserDetailsRequest request) {
        return new UserDetailsResponse(
                request.id(),
                request.name() != null ? request.name() : "Unknown",
                request.email() != null ? request.email() : "unknown@example.com"
        );
    }

    @Override
    public List<OrderHistoryResponse> getOrderHistory(OrderHistoryRequest request) {
        return List.of(
                new OrderHistoryResponse(UUID.randomUUID().toString(),
                        request.status() != null ? request.status() : "Processing",
                        request.date() != null ? request.date() : "2025-02-25")
        );
    }

    @Override
    public List<ProductRecommendationResponse> getRecommendations(ProductRecommendationRequest request) {
        return List.of(
                new ProductRecommendationResponse(
                        request.category() != null ? request.category() : "Electronics",
                        299.99,
                        4.5
                )
        );
    }

    @Override
    public UserDashboardResponse getUserDashboard(UserDashboardRequest request) {
        UserResponse userInfo = new UserResponse(
                request.userId(),
                request.name() != null ? request.name() : "Guest User",
                request.email() != null ? request.email() : "guest@example.com"
        );

        List<ActivityLogResponse> activities = List.of(
                new ActivityLogResponse(1, "Logged in", "2025-02-25T10:00"),
                new ActivityLogResponse(2, "Viewed dashboard", "2025-02-25T10:05"),
                new ActivityLogResponse(3, "Checked notifications", "2025-02-25T10:10")
        );

        List<NotificationResponse> notifications = List.of(
                new NotificationResponse(1, "Welcome to our platform!", "Unread"),
                new NotificationResponse(2, "Your order has been shipped.", "Unread"),
                new NotificationResponse(3, "New promotional offer available!", "Read")
        );

        return new UserDashboardResponse(userInfo, activities, notifications);
    }

    @Override
    public List<ProductCatalogResponse> getProductCatalog(ProductCatalogRequest request) {
        return List.of(
                new ProductCatalogResponse(
                        101, request.category() + " Laptop", 799.99, request.availableOnly(), 4.5,
                        new ProductSpecificationResponse("Brand A", "Black", "1 Year")
                ),
                new ProductCatalogResponse(
                        102, request.category() + " Smartphone", 499.99, request.availableOnly(), 4.3,
                        new ProductSpecificationResponse("Brand B", "White", "2 Years")
                ),
                new ProductCatalogResponse(
                        103, request.category() + " Tablet", 299.99, request.availableOnly(), 4.1,
                        new ProductSpecificationResponse("Brand C", "Silver", "6 Months")
                )
        );
    }

}

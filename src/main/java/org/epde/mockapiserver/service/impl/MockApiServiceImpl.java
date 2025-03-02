package org.epde.mockapiserver.service.impl;

import org.epde.mockapiserver.dto.request.OrderRequest;
import org.epde.mockapiserver.dto.request.UserRequest;
import org.epde.mockapiserver.dto.response.OrderResponse;
import org.epde.mockapiserver.dto.response.OrderStatusUpdate;
import org.epde.mockapiserver.dto.response.ProductResponse;
import org.epde.mockapiserver.dto.response.UserResponse;
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
        return new ProductResponse(0, name, price, true);
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
    public String deleteOrder(String orderId) {
        return "Order with ID " + orderId + " has been deleted successfully.";
    }

    @Override
    public String getApiStatus() {
        return "API is running smoothly";
    }
}

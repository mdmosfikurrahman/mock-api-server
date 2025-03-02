package org.epde.mockapiserver.service;

import org.epde.mockapiserver.dto.request.*;
import org.epde.mockapiserver.dto.response.*;

import java.util.List;

public interface MockApiService {
    UserResponse getUser();
    UserResponse getUserById(int id);
    UserResponse updateUser(int id, UserRequest userRequest);

    List<ProductResponse> getProducts();
    ProductResponse getProductDetails(String name, double price);

    OrderResponse placeOrder(OrderRequest orderRequest);
    OrderStatusUpdate updateOrderStatus(String orderId, String status);

    String deleteOrder(String orderId);
    String getApiStatus();
}

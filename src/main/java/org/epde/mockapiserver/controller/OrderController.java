package org.epde.mockapiserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.epde.mockapiserver.dto.request.OrderHistoryRequest;
import org.epde.mockapiserver.dto.request.OrderRequest;
import org.epde.mockapiserver.dto.response.DeleteOrderResponse;
import org.epde.mockapiserver.dto.response.OrderHistoryResponse;
import org.epde.mockapiserver.dto.response.OrderResponse;
import org.epde.mockapiserver.dto.response.OrderStatusUpdate;
import org.epde.mockapiserver.service.MockApiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Tag(name = "Order APIs", description = "Endpoints for managing orders")
public class OrderController {

    private final MockApiService mockApiService;

    @Operation(summary = "Place Order", description = "Create a new order")
    @PostMapping
    public OrderResponse placeOrder(@RequestBody OrderRequest orderRequest) {
        return mockApiService.placeOrder(orderRequest);
    }

    @Operation(summary = "Delete Order", description = "Delete an order by order ID")
    @DeleteMapping("/{orderId}")
    public DeleteOrderResponse deleteOrder(@PathVariable String orderId) {
        return mockApiService.deleteOrder(orderId);
    }

    @Operation(summary = "Update Order Status", description = "Update the status of an order by order ID")
    @PatchMapping("/{orderId}/status")
    public OrderStatusUpdate updateOrderStatus(@PathVariable String orderId, @RequestParam String status) {
        return mockApiService.updateOrderStatus(orderId, status);
    }

    @Operation(summary = "Get Order Status", description = "Get the Order Status by Request Body")
    @GetMapping("/history")
    public List<OrderHistoryResponse> getOrderHistory(@RequestBody OrderHistoryRequest request) {
        return mockApiService.getOrderHistory(request);
    }

}
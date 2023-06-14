package org.example.controller;

import org.example.exceptions.AppException;
import org.example.exceptions.DBException;
import org.example.model.Order;
import org.example.response.APIResponse;
import org.example.service.OrderService;
import org.example.service.implementation.OrderServiceImpl;

public class OrderController {

    private final OrderService orderService;

    public OrderController() {

        this.orderService = new OrderServiceImpl();
    }
    public APIResponse<Order> cancelOrder(String orderId) {
        try {
           Order order = orderService.cancelOrder(orderId);
            if (order != null) {
                return new APIResponse<>(order, "order cancelled successfully", 200);
            }
        } catch (AppException | DBException e){
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(null, "order cancelled successfully", 200);
    }

    public APIResponse<Object> retrieveOrder(String orderId) {
        try {
            Object order = orderService.retrieveOrder(orderId);
            if (order != null) {
                return new APIResponse<>(order, "Order retrieved successfully", 200);
            } else {
                return new APIResponse<>(null, "Order not found", 404);
            }
        } catch (AppException | DBException e) {
            return new APIResponse<>(null, e.getMessage(), 400);
        }
    }

    public APIResponse<Object> retrieveUserOrder(String userId) {

        try {
            Object order = orderService.retrieveUserOrder(userId);
            if (order != null) {
                return new APIResponse<>(order, "Customer order retrieved successfully", 200);
            } else {
                return new APIResponse<>(null, "Order not found", 404);
            }
        } catch (AppException | DBException e) {
            return new APIResponse<>(null, e.getMessage(), 400);
        }
    }
}

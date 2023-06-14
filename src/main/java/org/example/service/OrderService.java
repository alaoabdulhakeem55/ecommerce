package org.example.service;


import org.example.model.Order;

public interface OrderService {
    Order cancelOrder(String orderId);
    Order retrieveOrder(String orderId);
    Object retrieveUserOrder(String orderId);

}

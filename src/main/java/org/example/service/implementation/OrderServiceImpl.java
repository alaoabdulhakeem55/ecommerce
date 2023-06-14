package org.example.service.implementation;

import org.example.enums.OrderStatus;
import org.example.model.Order;
import org.example.model.Product;
import org.example.repository.OrderRepo;
import org.example.repository.ProductRepo;
import org.example.resources.Resources;
import org.example.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;

    public OrderServiceImpl() {
        this.orderRepo = Resources.orderRepo;
        this.productRepo = Resources.productRepo;
    }

    @Override
    public Order cancelOrder(String orderId) {
        Order order = orderRepo.getById(orderId);
        if (order.getStatus() == OrderStatus.PENDING || order.getStatus() == OrderStatus.CHECKOUT) {
            order.setStatus(OrderStatus.UNDELIVERED);
            orderRepo.update(order);
            String productId = order.getProductId();
            Product product = productRepo.getById(productId);
            int newQuantity = order.getQuantity() + product.getQuantity();
            product.setQuantity(newQuantity);
        } else {
            System.out.println("Unable to cancel order.");
        }
        return order;
    }

    @Override
    public Order retrieveOrder(String orderId) {
        return orderRepo.getById(orderId);
    }

    @Override
    public Object retrieveUserOrder(String userId) {
        return orderRepo.getByUserId(userId);

    }
}

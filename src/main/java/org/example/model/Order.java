package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.OrderStatus;

@Getter
@Setter
public class Order extends Base implements Identifiable {
    private String userId;
    private String productId;
    private int quantity;
    private double price;
    private OrderStatus status;

    public Order(String id, String userId, String productId, int quantity, double price) {
        super(id);
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.status = OrderStatus.PENDING;
    }

    @Override
    public String toString() {
        return "Order{" +
                "userId='" + userId + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", cost=" + price +
                ", orderId=" + super.getId() +
                ", status=" + status +
                '}';
    }
}

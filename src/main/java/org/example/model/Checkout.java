package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.CheckoutStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Checkout extends Base implements Identifiable {

    private String userId;
    private List<String> listOfOrderId;
    private CheckoutStatus status;
    private double totalPrice;

    public Checkout(String id, String userId) {
        super(id);
        this.userId = userId;
        this.listOfOrderId = new ArrayList<>();
        this.totalPrice = 0.0;
        this.status = CheckoutStatus.UNPAID;
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "userId='" + userId + '\'' +
                ", listOfOrderId=" + listOfOrderId +
                ", status=" + status +
                ", totalPrice=" + totalPrice +
                '}';
    }

}

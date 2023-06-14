package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cart extends Base implements Identifiable {
    private final String userId;
    private List<Item> itemList;

    public Cart (String id, String userId) {
        super(id);
        this.userId = userId;
        this.itemList = new ArrayList<>();
    }
    @Getter
    @Setter
    public static class Item {
        private String name;
        private String productId;
        private int quantity;
        private double unitPrice;

        public Item(String name, String productId, int quantity, double unitPrice) {
            this.name = name;
            this.productId = productId;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", productId='" + productId + '\'' +
                    ", quantity=" + quantity +
                    ", unitPrice=" + unitPrice +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "userId='" + userId + '\'' +
                ", itemList=" + itemList +
                '}';
    }
}

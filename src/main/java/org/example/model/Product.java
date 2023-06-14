package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends Base implements Identifiable {
    private String name;
    private double price;
    private int quantity;

    public Product(String id, String name, double price, int quantity) {
        super(id);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id='" + super.getId() + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
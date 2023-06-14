package org.example.service;

import org.example.model.Product;

import java.util.List;

public interface ProductService {
    Product addToStore(String name, double price, int quantity);
    Product removeFromStore(String id);
    Object getAll();
    Product findById(String id);
}

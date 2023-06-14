package org.example.service;

import org.example.model.Cart;

import java.util.List;

public interface CartService {
    Cart addToCart(String productId, String userId, int quantity);
    Cart reduceCartQuantity(String productId, String userId, int quantity);
    Object getAll();
    Cart findByUserId(String userId);
}

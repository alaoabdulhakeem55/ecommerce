package org.example.controller;

import org.example.exceptions.AppException;
import org.example.exceptions.DBException;
import org.example.model.Cart;
import org.example.repository.CartRepo;
import org.example.repository.ProductRepo;
import org.example.repository.implementation.map.CartRepoImplMap;
import org.example.repository.implementation.map.ProductRepoImplMap;
import org.example.response.APIResponse;
import org.example.service.CartService;
import org.example.service.implementation.CartServiceImpl;

import java.util.HashMap;

public class CartController {
    private final CartService cartService;

    public CartController() {
        this.cartService = new CartServiceImpl();

    }
    public APIResponse<Cart> addToCart(String productId, String userId, int quantity) {
        Cart cart;
        try {
            cart = cartService.addToCart(productId, userId, quantity);
        } catch (AppException | DBException e){
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(cart, "product successfully added to cart", 200);
    }

    public APIResponse<Cart> reduceCartQuantity(String productId, String userId, int quantity) {
        Cart cart;
        try {
            cart = cartService.reduceCartQuantity(productId, userId , quantity);
        } catch (AppException | DBException e) {
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(cart, "product successfully removed from cart", 200);
    }
    public APIResponse<Object> getAll() {
        Object cartList;
        try {
            cartList = cartService.getAll();
        } catch (AppException | DBException e) {
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(cartList, "List of all products in the cart", 200);
    }

    public APIResponse<Cart> findByUserId(String userId) {
        Cart cart;
        try {
            cart = cartService.findByUserId(userId);
        } catch (AppException | DBException e) {
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(cart, "customer cart retrieved", 200);
    }
}

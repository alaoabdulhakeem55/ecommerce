package org.example.service.implementation;

import org.example.exceptions.AppException;
import org.example.model.Cart;
import org.example.model.Product;
import org.example.repository.CartRepo;
import org.example.repository.ProductRepo;
import org.example.resources.Resources;
import org.example.service.CartService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartServiceImpl implements CartService {
    private final CartRepo cartRepo;
    private final ProductRepo productRepo;

    public CartServiceImpl() {
        this.cartRepo = Resources.cartRepo;
        this.productRepo = Resources.productRepo;
    }

    @Override
    public Cart addToCart(String productId, String userId, int quantity) {
        Cart cart = cartRepo.findByUserId(userId);
        if (cart == null) {
            Cart newCart = new Cart("", userId);
            cart = cartRepo.save(newCart);
        }

        Product product = productRepo.getById(productId);
        if (product == null) {
            throw new AppException("Product not found with ID: " + productId);
        }

        if (quantity > product.getQuantity()) {
            throw new AppException("Product out of stock. Available quantity: " + product.getQuantity());
        }

        List<Cart.Item> itemList = new ArrayList<>(cart.getItemList());
        itemList = handleItem(itemList, product, quantity);
        cart.setItemList(itemList);

        return cartRepo.save(cart);

    }
    public List<Cart.Item> handleItem(List<Cart.Item> itemList, Product product, int quantity) {
        for (Cart.Item item : itemList) {
            if (Objects.equals(item.getProductId(), product.getId())) {
                int newQuantity = item.getQuantity() + quantity;
                if (newQuantity > product.getQuantity()) {
                    throw new AppException("Product out of stock. Available quantity: " + product.getQuantity());
                }
                item.setQuantity(newQuantity);
                item.setUnitPrice(product.getPrice());
                return itemList;
            }
        }

        Cart.Item newItem = new Cart.Item(product.getName(), product.getId(), quantity, product.getPrice());
        itemList.add(newItem);
        return itemList;
    }

    @Override
    public Cart reduceCartQuantity(String productId, String userId, int quantity) {
        Cart cart = cartRepo.findByUserId(userId);
        if (cart == null) {
            throw new AppException("Cart not found for user ID: " + userId);
        }

        List<Cart.Item> itemList = new ArrayList<>(cart.getItemList());
        Product product = productRepo.getById(productId);
        if (product == null) {
            throw new AppException("Product not found with ID: " + productId);
        }

        for (int i = 0; i < itemList.size(); i++) {
            Cart.Item item = itemList.get(i);
            if (Objects.equals(item.getProductId(), product.getId())) {
                int newQuantity = item.getQuantity() - quantity;
                if (newQuantity < 0) {
                    throw new AppException("Invalid quantity to reduce. Item quantity: " + item.getQuantity());
                }
                item.setQuantity(newQuantity);
                if (newQuantity == 0) {
                    itemList.remove(i);
                }
                return cartRepo.save(cart);
            }
        }

        throw new AppException("Product not found in the cart for ID: " + productId);
    }

    @Override
    public Object getAll() {
        return cartRepo.getList();
    }

    @Override
    public Cart findByUserId(String userId) {
        return cartRepo.findByUserId(userId);
    }
}
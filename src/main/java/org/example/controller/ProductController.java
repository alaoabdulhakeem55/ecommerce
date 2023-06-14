package org.example.controller;

import org.example.exceptions.AppException;
import org.example.exceptions.DBException;
import org.example.model.Product;
import org.example.repository.ProductRepo;
import org.example.repository.implementation.map.ProductRepoImplMap;
import org.example.response.APIResponse;
import org.example.service.ProductService;
import org.example.service.implementation.ProductServiceImpl;

import java.util.HashMap;
import java.util.List;

public class ProductController {

    private final ProductService productService;

    public ProductController() {

        this.productService = new ProductServiceImpl();
    }
    public APIResponse<Product> addToStore(String name, double price, int quantity) {
        Product product;
        try {
            product = productService.addToStore(name, price, quantity);
        } catch (AppException | DBException e){
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(product, "product successfully added", 200);
    }

    public APIResponse<Product> removeFromStore(String id) {
        Product product;
        try {
            product = productService.removeFromStore(id) ;
        } catch (AppException | DBException e) {
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(product, "product has been removed from store", 200);
    }

    public APIResponse<Object> getAll() {
        Object productList;
        try {
            productList = productService.getAll();
        } catch (AppException | DBException e) {
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(productList, "list of all products", 200);
    }
    public APIResponse<Product> findById(String id) {
        Product product;
        try {
            product = productService.findById(id);
        } catch (AppException | DBException e) {
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(product, "product found", 200);
    }
}

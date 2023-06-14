package org.example.service.implementation;

import org.example.model.Product;
import org.example.repository.ProductRepo;
import org.example.repository.implementation.list.ProductRepoImplList;
import org.example.repository.implementation.list.StaffRepoImplList;
import org.example.repository.implementation.map.ProductRepoImplMap;
import org.example.repository.implementation.map.StaffRepoImplMap;
import org.example.resources.Resources;
import org.example.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    public ProductServiceImpl() {
        this.productRepo = Resources.productRepo;
    }


    @Override
    public Product addToStore(String name, double price, int quantity) {
        Product product = productRepo.findByName(name);
        if(product != null) {
            int newQuantity = product.getQuantity() + quantity;
            product.setQuantity(newQuantity);
        } else {
            product = new Product("", name, price, quantity);
        }
        return productRepo.save(product);
    }

    @Override
    public Product removeFromStore(String id) {
        productRepo.getById(id);
        return productRepo.deleteById(id);
    }

    @Override
    public Object getAll() {
        return productRepo.getList();
    }

    @Override
    public Product findById(String id) {
        return productRepo.getById(id);
    }
}

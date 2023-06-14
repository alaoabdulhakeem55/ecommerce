package org.example.repository.implementation.map;

import org.example.model.Product;
import org.example.repository.ProductRepo;
import org.example.repository.implementation.map.MapGenericRepo;

import java.util.Map;
import java.util.Objects;

public class ProductRepoImplMap extends MapGenericRepo<Product> implements ProductRepo {

    public ProductRepoImplMap(Map<String,Product> list) {
        super(list, "product");
    }

    @Override
    public Product findByName(String name) {
        for(Product product : this.getList().values()) {
            if(Objects.equals(product.getName(), name)) {
                return product;
            }
        }
        return null;
    }


}

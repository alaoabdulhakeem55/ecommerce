package org.example.repository.implementation.list;

import org.example.model.Product;
import org.example.repository.ProductRepo;
import org.example.repository.implementation.map.MapGenericRepo;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ProductRepoImplList extends ListGenericRepo<Product> implements ProductRepo {

    public ProductRepoImplList(List<Product> list, String name) {
        super(list, name);
    }

    @Override
    public Product findByName(String name) {
        for(Product product : this.getList()) {
            if(Objects.equals(product.getName(), name)) {
                return product;
            }
        }
        return null;
    }


}

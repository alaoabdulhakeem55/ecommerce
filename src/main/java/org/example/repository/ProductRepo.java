package org.example.repository;

import org.example.model.Identifiable;
import org.example.model.Product;

import java.util.List;

public interface ProductRepo extends GenericRepo<Product> {

    Product findByName(String name);

}

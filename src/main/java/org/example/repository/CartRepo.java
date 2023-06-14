package org.example.repository;

import org.example.model.Cart;

import java.util.Map;

public interface CartRepo extends GenericRepo<Cart> {

    Cart findByUserId(String userId);

}

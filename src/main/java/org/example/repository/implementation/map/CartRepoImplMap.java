package org.example.repository.implementation.map;

import org.example.model.Cart;
import org.example.repository.CartRepo;
import org.example.repository.implementation.map.MapGenericRepo;

import java.util.Map;
import java.util.Objects;

public class CartRepoImplMap extends MapGenericRepo<Cart> implements CartRepo {

    public CartRepoImplMap(Map<String, Cart> map) {
        super(map, "cart");
    }


    @Override
    public Cart findByUserId(String userId) {
        for(Cart cart : this.getList().values()) {
            if(Objects.equals(cart.getUserId(), userId)) {
                return cart;
            }
        }
        return null;
    }
}

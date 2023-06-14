package org.example.repository.implementation.list;

import org.example.model.Cart;
import org.example.repository.CartRepo;

import java.util.List;
import java.util.Objects;

public class CartRepoImplList extends ListGenericRepo<Cart> implements CartRepo {

    public CartRepoImplList(List<Cart> list, String name) {
        super(list, name);
    }


    @Override
    public Cart findByUserId(String userId) {
        for(Cart cart : this.getList())  {
            if(Objects.equals(cart.getUserId(), userId)) {
                return cart;
            }
        }
        return null;
    }
}

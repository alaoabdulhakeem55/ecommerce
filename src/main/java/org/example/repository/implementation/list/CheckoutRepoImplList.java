package org.example.repository.implementation.list;

import org.example.model.Checkout;
import org.example.repository.CheckoutRepo;
import org.example.repository.implementation.map.MapGenericRepo;

import java.util.List;
import java.util.Map;

public class CheckoutRepoImplList extends ListGenericRepo<Checkout> implements CheckoutRepo {
    public CheckoutRepoImplList(List<Checkout> list, String name) {
        super(list, name);
    }

}

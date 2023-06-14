package org.example.repository.implementation.map;

import org.example.model.Checkout;
import org.example.repository.CheckoutRepo;

import java.util.Map;

public class CheckoutRepoImplMap extends MapGenericRepo<Checkout> implements CheckoutRepo {
    public CheckoutRepoImplMap(Map<String, Checkout> map) {
        super(map, "checkout");
    }

}

package org.example.resources;

import org.example.repository.*;
import org.example.repository.implementation.map.*;

import java.util.HashMap;

public class Resources {
    public static final OrderRepo orderRepo = new OrderRepoImplMap(new HashMap<>());
    public static final  ProductRepo productRepo = new ProductRepoImplMap(new HashMap<>());
    public static final CustomerRepo customerRepo = new CustomerRepoImplMap(new HashMap<>());
    public static final CheckoutRepo checkoutRepo = new CheckoutRepoImplMap(new HashMap<>());
    public static final CartRepo cartRepo = new CartRepoImplMap(new HashMap<>());
    public static final StaffRepo staffRepo = new StaffRepoImplMap(new HashMap<>());
    public static final PaymentDetailsRepo paymentDetailRepo = new PaymentDetailsRepoImplMap(new HashMap<>());

}

package org.example.service;

import org.example.model.Cart;
import org.example.model.Checkout;

public interface CheckoutService {
    Checkout initiateCheckout(Cart cart);
    Checkout finaliseCheckout(Checkout checkout);
}

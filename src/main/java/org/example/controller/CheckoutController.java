package org.example.controller;

import org.example.exceptions.AppException;
import org.example.exceptions.DBException;
import org.example.model.Cart;
import org.example.model.Checkout;
import org.example.response.APIResponse;
import org.example.service.CheckoutService;
import org.example.service.implementation.CheckoutServiceImpl;

import java.util.HashMap;

public class CheckoutController {
    private final CheckoutService checkoutService;

    public CheckoutController() {

        this.checkoutService = new CheckoutServiceImpl();
    }

    public APIResponse<Checkout> initiateCheckout(Cart cart) {
        Checkout checkout;
        try {
            checkout = checkoutService.initiateCheckout(cart);
        } catch (AppException | DBException e){
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(checkout, "checkout successfully initiated", 200);
    }

    public APIResponse<Checkout> finaliseCheckout(Checkout checkout) {

        try {
            checkout = checkoutService.finaliseCheckout(checkout);
            if(checkout != null) {
                return new APIResponse<>(checkout, "checkout successfully processed", 200);
            }
        } catch (AppException | DBException e){
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(null, "checkout successfully processed", 200);
    }
}


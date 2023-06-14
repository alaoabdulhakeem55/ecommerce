package org.example.controller;

import org.example.exceptions.AppException;
import org.example.exceptions.DBException;
import org.example.model.PaymentDetails;
import org.example.repository.PaymentDetailsRepo;
import org.example.repository.implementation.map.PaymentDetailsRepoImplMap;
import org.example.response.APIResponse;
import org.example.service.PaymentDetailsService;
import org.example.service.implementation.PaymentDetailsServiceImpl;

import java.util.HashMap;

public class PaymentDetailsController {
    private final PaymentDetailsService paymentDetailsService;

    public PaymentDetailsController() {

        this.paymentDetailsService = new PaymentDetailsServiceImpl();
    }

    public APIResponse<PaymentDetails> savePaymentDetails(String creditCardNumber, String expirationDate, String cvv, double amount) {
        PaymentDetails paymentDetails;
        try {
            paymentDetails = paymentDetailsService.savePaymentDetails(creditCardNumber, expirationDate, cvv, amount);
        } catch (AppException | DBException e){
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(paymentDetails, "payment details successfully saved", 200);
    }

    public APIResponse<PaymentDetails> validatePaymentDetails(PaymentDetails paymentDetails) {

        try {
            paymentDetails = paymentDetailsService.validatePaymentDetails(paymentDetails);
        } catch (AppException | DBException e){
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(paymentDetails, "payment details successfully validated", 200);
    }
}

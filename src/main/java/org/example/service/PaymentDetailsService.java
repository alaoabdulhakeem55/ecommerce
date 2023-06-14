package org.example.service;

import org.example.model.PaymentDetails;

public interface PaymentDetailsService {
    PaymentDetails savePaymentDetails (String creditCardNumber, String expirationDate, String cvv, double amount);
    PaymentDetails validatePaymentDetails(PaymentDetails paymentDetails);
}

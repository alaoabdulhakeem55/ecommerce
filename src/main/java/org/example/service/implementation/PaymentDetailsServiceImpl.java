package org.example.service.implementation;

import org.example.exceptions.AppException;
import org.example.model.PaymentDetails;
import org.example.repository.PaymentDetailsRepo;
import org.example.resources.Resources;
import org.example.service.PaymentDetailsService;

public class PaymentDetailsServiceImpl implements PaymentDetailsService {
    private final PaymentDetailsRepo paymentDetailsRepo;

    public PaymentDetailsServiceImpl() {
        this.paymentDetailsRepo = Resources.paymentDetailRepo;
    }

    @Override
    public PaymentDetails savePaymentDetails(String creditCardNumber, String expirationDate, String cvv, double amount) {
        PaymentDetails paymentDetails = new PaymentDetails("", creditCardNumber, expirationDate, cvv, amount);
        validatePaymentDetails(paymentDetails);
        return paymentDetailsRepo.save(paymentDetails);
    }

    @Override
    public PaymentDetails validatePaymentDetails(PaymentDetails paymentDetails) {

        if (paymentDetails == null || paymentDetails.getCreditCardNumber() == null
                || paymentDetails.getExpirationDate() == null || paymentDetails.getCvv() == null) {
            throw new AppException("Invalid payment details");
        } else {
            paymentDetailsRepo.save(paymentDetails);
        }
        return paymentDetailsRepo.save(paymentDetails);
    }

}

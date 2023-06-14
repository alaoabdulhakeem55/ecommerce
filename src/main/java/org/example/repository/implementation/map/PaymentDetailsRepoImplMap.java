package org.example.repository.implementation.map;

import org.example.model.PaymentDetails;
import org.example.repository.PaymentDetailsRepo;
import org.example.repository.implementation.map.MapGenericRepo;

import java.util.Map;

public class PaymentDetailsRepoImplMap extends MapGenericRepo<PaymentDetails> implements PaymentDetailsRepo {

    public PaymentDetailsRepoImplMap(Map<String, PaymentDetails> map) {
        super(map, "payment detail");
    }
}

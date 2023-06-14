package org.example.repository.implementation.list;

import org.example.model.PaymentDetails;
import org.example.repository.PaymentDetailsRepo;
import org.example.repository.implementation.map.MapGenericRepo;

import java.util.List;
import java.util.Map;

public class PaymentDetailsRepoImplList extends ListGenericRepo<PaymentDetails> implements PaymentDetailsRepo {

    public PaymentDetailsRepoImplList(List<PaymentDetails> list, String name) {
        super(list, name);
    }
}

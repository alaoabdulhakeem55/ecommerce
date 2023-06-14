package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDetails extends Base implements Identifiable {
    private final String creditCardNumber;
    private final String expirationDate;
    private final String cvv;
    private final double amount;

    public PaymentDetails(String id, String creditCardNumber, String expirationDate, String cvv, double amount) {
        super(id);
        this.creditCardNumber = creditCardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "creditCardNumber='" + creditCardNumber + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", cvv='" + cvv + '\'' +
                ", amount=" + amount +
                '}';
    }
}

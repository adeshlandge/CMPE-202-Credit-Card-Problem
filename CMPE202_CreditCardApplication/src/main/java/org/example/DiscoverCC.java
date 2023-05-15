package org.example;

public class DiscoverCC extends CreditCard{

    public DiscoverCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }
    @Override
    public String getType() {
        return "This is Discover credit card";
    }
}

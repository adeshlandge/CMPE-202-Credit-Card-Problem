package org.example;

public class MasterCC extends CreditCard{
    public MasterCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    public String getType() {
        return "This is an MasterCard Credit Card!";
    }
}

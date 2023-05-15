package org.example;

public class AmExCC extends CreditCard{
    public AmExCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    public String getType() {
        return "This is an American Express Credit Card!";
    }
}

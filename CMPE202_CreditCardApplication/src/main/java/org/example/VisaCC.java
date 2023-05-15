package org.example;

public class VisaCC extends CreditCard{

    public VisaCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }
    @Override
    public String getType() {
        return "This is a VISA credit card!";
    }
}

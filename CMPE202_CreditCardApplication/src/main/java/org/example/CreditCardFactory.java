package org.example;
import org.example.Constants;
public class CreditCardFactory {
    public static CreditCard createCreditCard(String typeOfCreditCard, String cardNumber, String expirationDate, String cardHolderName){
        if(typeOfCreditCard == Constants.AMEX){
            return new AmExCC(cardNumber, expirationDate, cardHolderName);

        } else if (typeOfCreditCard == Constants.MASTERCARD) {
            return new MasterCC(cardNumber, expirationDate, cardHolderName);
            
        } else if (typeOfCreditCard == Constants.VISA) {
            return new VisaCC(cardNumber, expirationDate, cardHolderName);
            
        } else if (typeOfCreditCard == Constants.DISCOVER) {
            
        }
        return null;
    }
}

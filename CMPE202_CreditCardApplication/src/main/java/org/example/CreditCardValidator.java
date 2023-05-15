package org.example;

import java.util.ArrayList;
import java.util.Iterator;

public class CreditCardValidator {
    public ArrayList<CardInfo> validate(ArrayList<CardInfo> cardInfoArrayList){
        Iterator itr = cardInfoArrayList.iterator();
        while(itr.hasNext())
        {
            CardInfo cardInfo = (CardInfo) itr.next();
            String cardNumber = cardInfo.getCardNumber();
            Boolean hasNonDigits = containsNonDigits(cardNumber);
            if(cardNumber!=null) {
                if (cardNumber.length() <= 19) {
                    if (cardNumber.startsWith("5")) {
                        if (cardNumber.length() == 16 &&
                                (cardNumber.charAt(1) == '1' || (cardNumber.charAt(1) == '2') || (cardNumber.charAt(1) == '3')
                                        || (cardNumber.charAt(1) == '4') || (cardNumber.charAt(1) == '5')
                                )) {
                            //Master CC
                            cardInfo.setCardType("MasterCard");
                        } else {
                            cardInfo.setCardType("Invalid: Not a possible card number");
                        }
                    } else if (cardNumber.startsWith("4")) {
                        if (cardNumber.length() == 13 || cardNumber.length() == 16) {
                            // Visa CC
                            cardInfo.setCardType("Visa");
                        } else {
                            cardInfo.setCardType("Invalid: Not a possible card number");
                        }
                    } else if (cardNumber.startsWith("3")) {
                        if (cardNumber.length() == 15 && (cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7')) {
                            // Amex CC
                            cardInfo.setCardType("AmericanExpress");
                        } else {
                            cardInfo.setCardType("Invalid: Not a possible card number");
                        }
                    } else if (cardNumber.startsWith("6011") && cardNumber.length() == 16 && !hasNonDigits) {
                        cardInfo.setCardType("Discover");
                    } else if (cardNumber.isBlank()) {
                        cardInfo.setCardType("Invalid: empty/null card number");
                    } else if (containsNonDigits(cardNumber)) {
                        cardInfo.setCardType("Invalid: non numeric characters");
                    } else {
                        cardInfo.setCardType("Invalid: Not a possible card number");
                    }
                } else {
                    cardInfo.setCardType("Invalid: more than 19 digits");
                }
            }
            else{
                cardInfo.setCardType("Invalid: empty/null card number");
            }
        }
        return cardInfoArrayList;
    }

    private boolean containsNonDigits(String str) {
        if(str == null) {
            return false;
        }
        for(int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}

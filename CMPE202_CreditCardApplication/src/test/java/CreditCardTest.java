import org.example.CardInfo;
import org.example.CreditCardValidator;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class CreditCardTest {
    @Test
    public void testMasterCreditCard() {
        ArrayList<CardInfo> cardInfoArrayList = new ArrayList<CardInfo>();
        CardInfo cardInfo = new CardInfo();
        cardInfo.setCardNumber("5567894523129089");
        cardInfoArrayList.add(cardInfo);

        CreditCardValidator creditCardValidator = new CreditCardValidator();
        ArrayList<CardInfo> result = creditCardValidator.validate(cardInfoArrayList);

        assertEquals(1, result.size());
        assertEquals("MasterCard",  result.get(0).getCardType());
    }

    @Test
    public void testInValidCreditCard() {
        ArrayList<CardInfo> cardInfoArrayList = new ArrayList<>();
        CardInfo cardInfo = new CardInfo();
        cardInfo.setCardNumber("59012345678901234567890");
        cardInfoArrayList.add(cardInfo);

        CreditCardValidator creditCardValidator = new CreditCardValidator();
        ArrayList<CardInfo> result = creditCardValidator.validate(cardInfoArrayList);

        assertEquals(1, result.size());
        assertEquals("Invalid: more than 19 digits", result.get(0).getCardType());
    }

    @Test
    public void testBlankCreditCard() {
        ArrayList<CardInfo> cardInfoArrayList = new ArrayList<>();
        CardInfo cardInfo = new CardInfo();
        cardInfo.setCardNumber("");
        cardInfoArrayList.add(cardInfo);

        CreditCardValidator creditCardValidator = new CreditCardValidator();
        ArrayList<CardInfo> result = creditCardValidator.validate(cardInfoArrayList);

        assertEquals(1, result.size());
        assertEquals("Invalid: empty/null card number", result.get(0).getCardType());
    }

    @Test
    public void testVisaCreditCard() {
        ArrayList<CardInfo> cardInfoArrayList = new ArrayList<>();
        CardInfo cardInfo = new CardInfo();
        cardInfo.setCardNumber("4123456789123");
        cardInfoArrayList.add(cardInfo);

        CreditCardValidator creditCardValidator = new CreditCardValidator();
        ArrayList<CardInfo> result = creditCardValidator.validate(cardInfoArrayList);

        assertEquals(1, result.size());
        assertEquals("Visa", result.get(0).getCardType());
    }

    @Test
    public void testAmexCreditCard() {
        ArrayList<CardInfo> cardInfoArrayList = new ArrayList<>();
        CardInfo cardInfo = new CardInfo();
        cardInfo.setCardNumber("347856341908126");
        cardInfoArrayList.add(cardInfo);

        CreditCardValidator creditCardValidator = new CreditCardValidator();
        ArrayList<CardInfo> result = creditCardValidator.validate(cardInfoArrayList);

        assertEquals(1, result.size());
        assertEquals("AmericanExpress", result.get(0).getCardType());
    }

    @Test
    public void testDiscoverCreditCard() {
        ArrayList<CardInfo> cardInfoArrayList = new ArrayList<>();
        CardInfo cardInfo = new CardInfo();
        cardInfo.setCardNumber("6011111100007756");
        cardInfoArrayList.add(cardInfo);

        CreditCardValidator creditCardValidator = new CreditCardValidator();
        ArrayList<CardInfo> result = creditCardValidator.validate(cardInfoArrayList);

        assertEquals(1, result.size());
        assertEquals("Discover", result.get(0).getCardType());
    }

    @Test
    public void testNotPossibleCreditCard() {
        ArrayList<CardInfo> cardInfoArrayList = new ArrayList<>();
        CardInfo cardInfo = new CardInfo();
        cardInfo.setCardNumber("3601112345678789");
        cardInfoArrayList.add(cardInfo);

        CreditCardValidator creditCardValidator = new CreditCardValidator();
        ArrayList<CardInfo> result = creditCardValidator.validate(cardInfoArrayList);

        assertEquals(1, result.size());
        assertEquals("Invalid: Not a possible card number", result.get(0).getCardType());
    }

    @Test
    public void testNonNumericCreditCard() {
        ArrayList<CardInfo> cardInfoArrayList = new ArrayList<>();
        CardInfo cardInfo = new CardInfo();
        cardInfo.setCardNumber("6011*890HJrt6789");
        cardInfoArrayList.add(cardInfo);

        CreditCardValidator creditCardValidator = new CreditCardValidator();
        ArrayList<CardInfo> result = creditCardValidator.validate(cardInfoArrayList);

        assertEquals(1, result.size());
        assertEquals("Invalid: non numeric characters", result.get(0).getCardType());
    }
}

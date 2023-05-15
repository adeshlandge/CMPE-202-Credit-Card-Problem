package org.example;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.example.CardInfo;

public class CreditCardManager {
    private CreditCardValidator creditCardValidator;
    private CreditCardFactory creditCardFactory;
    private FileReaderStrategy fileReaderStrategy;
    private FileWriterStrategy fileWriterStrategy;
    private ArrayList<CardInfo> cardInfoArrayList;
    public CreditCardManager(String inputFile, String outputFile) throws ParserConfigurationException, IOException, SAXException {
        createReader(inputFile);
        createWriter(outputFile);
        creditCardValidator = new CreditCardValidator();
        creditCardFactory = new CreditCardFactory();
        cardInfoArrayList = new ArrayList<CardInfo>();
    }

    private void createReader(String inputFile) throws ParserConfigurationException, IOException, SAXException {
        if (inputFile.endsWith(".json")) {
            fileReaderStrategy = new JsonReader(inputFile);
        } else if (inputFile.endsWith(".xml")) {
            fileReaderStrategy = new XmlReader(inputFile);
        } else if (inputFile.endsWith(".csv")) {
            fileReaderStrategy = new CsvReader(inputFile);
        } else {
            System.out.println("Input File extension not recognized");
        }
    }
    private void createWriter(String outputFile){
        if (outputFile.endsWith(".json")) {
            fileWriterStrategy = new JsonWriter(outputFile);
        } else if (outputFile.endsWith(".xml")) {
            fileWriterStrategy = new XmlWriter(outputFile);
        } else if (outputFile.endsWith(".csv")) {
            fileWriterStrategy = new CsvWriter(outputFile);
        } else {
            System.out.println("Input File extension not recognized");
        }
    }

    public void parse() throws ParserConfigurationException, IOException, SAXException {
        this.cardInfoArrayList = fileReaderStrategy.readFile();
        System.out.println("***Card Array List Before***");
        Iterator itr = this.cardInfoArrayList.iterator();
        while(itr.hasNext())
        {
            CardInfo cardInfo = (CardInfo) itr.next();
            System.out.println("Card Number: "+cardInfo.getCardNumber());
            System.out.println("Card Exp date: "+cardInfo.getExpirationDate());
            System.out.println("Card Holder: "+cardInfo.getCardHolderName());
            System.out.println("Card Type: "+cardInfo.getCardType());

        }
    }

    public void processCards() {
        // Iterate over array of credit card info
            // call validator.validate(cardInfo)
            // based on return value write into file
            // create a credit card object if no error based on type
        creditCardValidator.validate(this.cardInfoArrayList);
        System.out.println("***Card Array List After***");
        Iterator itr = this.cardInfoArrayList.iterator();
        while(itr.hasNext())
        {
            CardInfo cardInfo = (CardInfo) itr.next();
            System.out.println("Card Number: "+cardInfo.getCardNumber());
            System.out.println("Card Exp date: "+cardInfo.getExpirationDate());
            System.out.println("Card Holder: "+cardInfo.getCardHolderName());
            System.out.println("Card Type: "+cardInfo.getCardType());
        }
    }

    public void writeDataToFile() throws XMLStreamException, IOException {
        fileWriterStrategy.writeFile(this.cardInfoArrayList);
    }

}

package org.example;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XMLStreamException {
        System.out.println("Main Application started!");
        if (args.length < 2) {
            System.out.println("Please provide both input and output file names as command line arguments");
            return;
        }
        CreditCardManager creditCardManager = new CreditCardManager(args[0], args[1]); //passing input and output file names to CreditCardManager
        creditCardManager.parse();
        creditCardManager.processCards();
        creditCardManager.writeDataToFile();
    }
}
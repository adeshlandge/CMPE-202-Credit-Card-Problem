package org.example;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.example.Constants;

public class XmlReader implements FileReaderStrategy {
    private String fileName = null;
    public XmlReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public ArrayList<CardInfo> readFile() throws ParserConfigurationException, IOException, SAXException{
        ArrayList<CardInfo> cardInfoArrayList = new ArrayList<CardInfo>();
        try {
            File inputFile = new File(this.fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName(Constants.CARD);


            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    CardInfo cardInfo = new CardInfo();
                    cardInfo.setCardNumber((String) eElement.getElementsByTagName(Constants.CARD_NUMBER).item(0).getTextContent());
                    cardInfo.setExpirationDate((String) eElement.getElementsByTagName(Constants.EXPIRATION_DATE).item(0).getTextContent());
                    cardInfo.setCardHolderName((String) eElement.getElementsByTagName(Constants.CARD_HOLDER_NAME).item(0).getTextContent());
                    cardInfoArrayList.add(cardInfo);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return cardInfoArrayList;
    }
}

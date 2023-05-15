package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
public class XmlWriter implements FileWriterStrategy{

    private String fileName = null;
    public XmlWriter(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void writeFile(ArrayList<CardInfo> cardInfoArrayList) throws IOException, XMLStreamException {
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter xmlWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter(new File(this.fileName)));

        // Start writing XML document
        xmlWriter.writeStartDocument();
        xmlWriter.writeStartElement("CARDS");
        for (CardInfo cardInfo : cardInfoArrayList) {
            xmlWriter.writeStartElement("CARD");

            xmlWriter.writeStartElement("CARD_NUMBER");
            xmlWriter.writeCharacters(cardInfo.getCardNumber());
            xmlWriter.writeEndElement();

            xmlWriter.writeStartElement("CARD_TYPE");
            xmlWriter.writeCharacters(cardInfo.getCardType());
            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();
        }

        // End writing XML document
        xmlWriter.writeEndElement();
        xmlWriter.writeEndDocument();

        // Close XMLStreamWriter
        xmlWriter.flush();
        xmlWriter.close();
    }
}

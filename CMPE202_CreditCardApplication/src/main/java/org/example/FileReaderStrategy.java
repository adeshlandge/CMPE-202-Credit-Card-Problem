package org.example;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public interface FileReaderStrategy {
    ArrayList<CardInfo> readFile() throws ParserConfigurationException, IOException, SAXException;
}

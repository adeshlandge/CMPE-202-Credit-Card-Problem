package org.example;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;

public interface FileWriterStrategy {
    void writeFile(ArrayList<CardInfo> cardInfoArrayList) throws IOException, XMLStreamException;
}

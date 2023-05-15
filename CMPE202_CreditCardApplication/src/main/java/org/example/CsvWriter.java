package org.example;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
public class CsvWriter implements FileWriterStrategy{

    private String fileName = null;
    public CsvWriter(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void writeFile(ArrayList<CardInfo> cardInfoArrayList) {
        FileWriter fileWriter = null;

        try {

            fileWriter = new FileWriter(fileName);

            // Adding the Header
            fileWriter.append("cardNumber,cardType");
            fileWriter.append("\n");

            // Write individual card data rows
            for (CardInfo card : cardInfoArrayList) {
                fileWriter.append(card.getCardNumber());
                fileWriter.append(",");
                fileWriter.append(card.getCardType());
                fileWriter.append("\n");
            }

            System.out.println("CSV file was created successfully.");

        } catch (IOException e) {
            System.out.println("Error in CsvWriter!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !");
                e.printStackTrace();
            }
        }
    }
}

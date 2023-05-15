package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

public class CsvReader implements FileReaderStrategy {
    private String fileName = null;
    public CsvReader(String fileName){
        this.fileName = fileName;
    }
    @Override
    public ArrayList<CardInfo> readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        br.readLine(); //skipping first row
        String line;
        ArrayList<CardInfo> cardInfoArrayList = new ArrayList<CardInfo>();
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            //System.out.println("card # " + data[0] + " expDate " + data[1] + " card Holder "+data[2]);
            CardInfo cardInfo = new CardInfo();
            cardInfo.setCardNumber((String) data[0]);
            cardInfo.setExpirationDate((String) data[1]);
            cardInfo.setCardHolderName((String) data[2]);
            cardInfoArrayList.add(cardInfo);
        }
        return cardInfoArrayList;
    }
}

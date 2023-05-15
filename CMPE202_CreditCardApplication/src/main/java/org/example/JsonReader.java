package org.example;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class JsonReader implements FileReaderStrategy {

    private String fileName = null;
    public JsonReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public ArrayList<CardInfo> readFile() {
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        ArrayList<CardInfo> cardInfoArrayList = new ArrayList<CardInfo>();
        try {
            //Parsing the contents of the JSON file
            //JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(this.fileName));
            Object obj =  jsonParser.parse(new FileReader(this.fileName));
            System.out.println("obj==>"+obj);
            JSONObject jsonObj = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObj.get("cards");
            System.out.println("json array cards==>"+jsonArray);
            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) object;
                CardInfo cardInfo = new CardInfo();
                cardInfo.setCardNumber((String) jsonObject.get("cardNumber"));
                cardInfo.setExpirationDate((String) jsonObject.get("expirationDate"));
                cardInfo.setCardHolderName((String) jsonObject.get("cardHolderName"));
                cardInfoArrayList.add(cardInfo);
            }
        }
        catch (Exception ex ) {
            ex.printStackTrace();
        }
        return cardInfoArrayList;
    }
}

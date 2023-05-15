package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
public class JsonWriter implements FileWriterStrategy{

    private String fileName = null;
    public JsonWriter(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void writeFile(ArrayList<CardInfo> cardInfoArrayList) {
        JSONObject jsonObj = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (CardInfo cardInfo : cardInfoArrayList) {
            Map<String, Object> jsonObjectMap = new LinkedHashMap<String, Object>();
            jsonObjectMap.put("cardNumber", cardInfo.getCardNumber());
            jsonObjectMap.put("cardType", cardInfo.getCardType());
            JSONObject jsonObject = new JSONObject(jsonObjectMap);
            jsonArray.add(jsonObject);
        }
        jsonObj.put("cards",jsonArray);

        try (FileWriter file = new FileWriter(this.fileName)) {
            //file.write(jsonArray.toJSONString());
            file.write(jsonObj.toJSONString());
            file.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

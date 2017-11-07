package com.example.franck.fintechhomework.ThirdPoint;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.math.BigDecimal;

/**
 * Created by Franck on 07.11.2017.
 */

public class MoneyAmountDeserializer implements JsonDeserializer<MoneyAmount> {

    @Override
    public MoneyAmount deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        MoneyAmount moneyAmount = new MoneyAmount();
        String f = json.getAsJsonObject().get("money_amount").getAsString();
        BigDecimal b = new BigDecimal(f.replace(",",""));
        moneyAmount.setMoney_amount(b);
        return moneyAmount;
    }
}
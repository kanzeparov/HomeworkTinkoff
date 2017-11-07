package com.example.franck.fintechhomework.ForthPoint;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Franck on 07.11.2017.
 */

public class DateSerializer implements JsonSerializer<DateExample> {
    @Override
    public JsonElement serialize(DateExample src, Type typeOfSrc, JsonSerializationContext context) {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        JsonObject result = new JsonObject();
        result.addProperty("date", formatForDateNow.format(src.getDate()));
        return result;
    }
}

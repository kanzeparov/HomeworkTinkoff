package com.example.franck.fintechhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.franck.fintechhomework.FirstPoint.User;
import com.example.franck.fintechhomework.ForthPoint.DateExample;
import com.example.franck.fintechhomework.ForthPoint.DateSerializer;
import com.example.franck.fintechhomework.SecondPoint.AnyMap;
import com.example.franck.fintechhomework.SecondPoint.SecondName;
import com.example.franck.fintechhomework.ThirdPoint.MoneyAmount;
import com.example.franck.fintechhomework.ThirdPoint.MoneyAmountDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView firstPoint;
    private TextView secondPoint;
    private TextView thirdPoint;
    private TextView forthPoint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // First point
        firstPoint = (TextView) findViewById(R.id.firstTextView);
        User user1 = new User();
        user1.setFirstName("bob");
        user1.setLastName("anderson");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        String json = gson.toJson(user1);
        firstPoint.setText(json);
        // First point


        // Second point
        secondPoint = (TextView) findViewById(R.id.secondTextView);
        String secondJson = " {\"name\":\"name\",\"any_map\": {\"a\":\"55\",\"b\":\"85\",\"c\":\"56\"}}";
//        Map<String, SecondName> categoryMap = gson.fromJson(secondJson, new TypeToken<Map<String, SecondName>>(){}.getType());
//        secondPoint.setText(categoryMap.size());
        // Second point


        // Third point
        thirdPoint = (TextView) findViewById(R.id.thirdTextView);
        gson = new GsonBuilder().registerTypeAdapter(MoneyAmount.class, new MoneyAmountDeserializer())
                .create();
        json = " {\"money_amount\":\"2444,88\"}";
        MoneyAmount moneyAmount = gson.fromJson(json, MoneyAmount.class);
        thirdPoint.setText(moneyAmount.getMoney_amount().toString());
        // Third point


        // Forth point
        forthPoint = (TextView) findViewById(R.id.forthTextView);
        DateExample dateExample = new DateExample(new Date());
        gson = new GsonBuilder()
                .registerTypeAdapter(DateExample.class,new DateSerializer())
                .create();
        json = gson.toJson(dateExample);
        forthPoint.setText(json);

        // Forth point



    }
}

package com.example.franck.fintechhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LineChartView lineChartView = (LineChartView) findViewById(R.id.linechart);
        lineChartView.setChartData(getRandomData());
    }


    private float[] getRandomData() {
        return new float[] { 10, 12, 7, 14, 15, 19, 13, 2, 10, 13, 13, 10, 15, 14 };
    }
}

package com.example.franck.fintechhomework;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonBlack;
    private Button buttonBlue;
    private LineChartView lineChartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineChartView = (LineChartView) findViewById(R.id.linechart);
        lineChartView.setChartData(getRandomData());

        buttonBlue = (Button) findViewById(R.id.btnBlue);

        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineChartView.setChartData(getRandomData(), Color.BLUE);
            }
        });
    }


    private float[] getRandomData() {
        return new float[] { 10, 12, 7, 14, 15, 19, 13, 2, 10, 13, 13, 10, 15, 14 };
    }
}

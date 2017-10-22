package com.example.franck.fintechhomework;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private JSONTask jsonTask1;
    private TextView listView;
    private String[] currencies;
    private String saveStr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonTask1 = new JSONTask();
        jsonTask1.execute("2");

        Log.d("tag","create");
    }

    public class JSONTask extends AsyncTask<String,String, String[]>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            listView = (TextView) findViewById(R.id.listViewItems);
            listView.setText("1");


        }

        @Override
        protected String[] doInBackground(String... params) {
            if(saveStr == null) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return  params;
        }

        @Override
        protected void onPostExecute(String[] result) {

            super.onPostExecute(result);

            listView = (TextView) findViewById(R.id.listViewItems);
            if(saveStr == null) {
                saveStr = result[0];
            }
            listView.setText(listView.getText().toString() + " " + saveStr);
        }
    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("tag","Restor");
        saveStr = savedInstanceState.getString("string");

    }

    // Вызывается перед тем, как Активность становится "видимой".
    @Override
    public void onRestart(){
        super.onRestart();
        Log.d("tag","Restart");

    }

    // Вызывается в начале "видимого" состояния.
    @Override
    public void onStart(){
        super.onStart();
        Log.d("tag","Start");
        // Примените к UI все необходимые изменения, так как
        // Активность теперь видна на экране.
    }

    // Вызывается в начале "активного" состояния.
    @Override
    public void onResume(){
        super.onResume();
        Log.d("tag","Resume");


    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        Log.d("tag","Save");
        savedInstanceState.putString("string", saveStr);
    }

    @Override
    public void onPause(){

        super.onPause();
        Log.d("tag","Pause");
    }

    @Override
    public void onStop(){

        super.onStop();
        Log.d("tag","Stop");
        jsonTask1.cancel(true);

    }


    @Override
    public void onDestroy(){

        super.onDestroy();
        Log.d("tag","destroy");
    }

}

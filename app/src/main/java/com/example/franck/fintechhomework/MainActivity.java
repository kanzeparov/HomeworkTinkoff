package com.example.franck.fintechhomework;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.franck.fintechhomework.models.Rates;
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

    private JSONTask jsonTask;

    private ListView listView;
    private String[] currencies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            jsonTask = new JSONTask();
            jsonTask.execute("http://api.fixer.io/2000-01-03");


        Log.d("tag","create");
    }

    public class JSONTask extends AsyncTask<String,String, Rates>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }
//http://api.fixer.io/2000-01-03
        @Override
        protected Rates doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            Rates rates = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line ="";
                while ((line = reader.readLine()) != null){
                    buffer.append(line);
                }

                String finalJson = buffer.toString();
                Gson gson = new Gson();
                rates = gson.fromJson(finalJson, Rates.class);
                if (currencies == null)
                    Thread.sleep(5000);
                return rates;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(connection != null) {
                    connection.disconnect();
                }
                try {
                    if(reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return  rates;
        }

        @Override
        protected void onPostExecute(final Rates result) {
            super.onPostExecute(result);

            listView = (ListView) findViewById(R.id.listViewItems);
            if (result != null && currencies == null) {
                currencies = new String[result.getRates().size()];
                int i = 0;
                for (Map.Entry entry : result.getRates().entrySet()) {
                    currencies[i] = (String) entry.getKey();
                    i++;
                }
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,
                    currencies);
            if (adapter != null) {

                listView.setAdapter(adapter);
            }

        }
    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("tag","Restor");

        currencies = savedInstanceState.getStringArray("string_array");

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
        savedInstanceState.putStringArray("string_array", currencies);
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
        if(jsonTask != null) {
            jsonTask.cancel(true);
        }
    }


    @Override
    public void onDestroy(){

        super.onDestroy();
        Log.d("tag","destroy");
    }

}

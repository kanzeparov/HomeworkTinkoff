package com.example.franck.fintechhomework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    EditText editText;
    DBHelper dbHelper;
    Button buttonAdd;
    Button buttonNode;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editTextId);
        buttonAdd = (Button) findViewById(R.id.buttonIdAdd);
        buttonNode = (Button) findViewById(R.id.buttonIdNode);
        textView = (TextView) findViewById(R.id.textViewId);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          ContentValues cv = new ContentValues();

                                          String node = editText.getText().toString();
                                          SQLiteDatabase db = dbHelper.getWritableDatabase();
                                          cv.put("node", node);
                                          long rowID = db.insert("mytable", null, cv);
                                          textView.setText("\"--- Insert in mytable: ---\\n" +"row inserted, ID = " + rowID );

                                          dbHelper.close();
                                      }
                                  });
        buttonNode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();

                SQLiteDatabase db = dbHelper.getWritableDatabase();

                Cursor c = db.query("mytable", null, null, null, null, null, null);

                // ставим позицию курсора на первую строку выборки
                // если в выборке нет строк, вернется false
                if (c.moveToFirst()) {

                    // определяем номера столбцов по имени в выборке
                    int idColIndex = c.getColumnIndex("id");
                    int nameColIndex = c.getColumnIndex("node");

                    do {
                        // получаем значения по номерам столбцов и пишем все в лог\
                        // переход на следующую строку
                        // а если следующей нет (текущая - последняя), то false - выходим из цикла
                        textView.setText("\"--- Rows in mytable: ---\n"+"ID = " + c.getInt(idColIndex) +
                                ", node = " + c.getString(nameColIndex) + textView.getText());
                    } while (c.moveToNext());
                } else
                    textView.setText("0 rows");
                c.close();
            }
        });

        dbHelper = new DBHelper(this);
    }



    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            // конструктор суперкласса
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "--- onCreate database ---");
            // создаем таблицу с полями
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "node text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}

package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mBtnSave, mBtnLoad, mBtnClear;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.editText1);
        mBtnSave = (Button)findViewById(R.id.btnSave);
        mBtnLoad = (Button)findViewById(R.id.btnLoad);
        mBtnClear = (Button)findViewById(R.id.btnClear);
        mBtnSave.setOnClickListener(btnSaveOnClick);
        mBtnLoad.setOnClickListener(btnLoadOnClick);
        mBtnClear.setOnClickListener(btnClearOnClick);
    }
    private View.OnClickListener btnSaveOnClick = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            // get a SharedPreference object
            SharedPreferences nameInfo = getSharedPreferences("Name_Info",MODE_PRIVATE);
            // get an Editor from the SharedPreference object
            nameInfo.edit()
                    .putString("Name", name.getText().toString())
                    .commit();
            Toast.makeText(MainActivity.this, "Save Completed",Toast.LENGTH_SHORT)
                    .show();
        }
    };
    private View.OnClickListener btnLoadOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            SharedPreferences nameInfo = getSharedPreferences("Name_Info", MODE_PRIVATE);
            String data = nameInfo.getString("Name", "NULL");
            name.setText(data);
            Toast.makeText(MainActivity.this, "Load Completed",Toast.LENGTH_SHORT)
                    .show();
        }
    };
    private View.OnClickListener btnClearOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            SharedPreferences nameInfo = getSharedPreferences("Name_Info",MODE_PRIVATE);
            nameInfo.edit()
                    .clear()
                    .commit();
            Toast.makeText(MainActivity.this, "Clear Completed",Toast.LENGTH_SHORT)
                    .show();
        }
    };
}
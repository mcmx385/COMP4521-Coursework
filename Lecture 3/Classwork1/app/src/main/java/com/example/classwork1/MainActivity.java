package com.example.classwork1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double rate=17.14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("CW1");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0F9D58")));
    }

    public void convert(View v){
        EditText amountInputBox = (EditText) findViewById(R.id.amountInputBox);
        int amount = Integer.parseInt(amountInputBox.getText().toString());
        double result = amount*this.rate;
        TextView resultText=(TextView) findViewById(R.id.resultText);
        resultText.setTextSize(30);
        resultText.setText("Total JPY is: "+String.valueOf(result));
    }
}
package com.example.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button) findViewById(R.id.button);
        btn.setOnClickListener(sayHi);
    }

    private View.OnClickListener sayHi = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText name = (EditText) findViewById(R.id.name);
            TextView txv = (TextView) findViewById(R.id.txv);
            txv.setTextSize(30);
            txv.setText(name.getText().toString() + ", Welcome to COMP4521!");
        }
    };

    public void convert(View v){
        EditText value=(EditText) findViewById(R.id.name);
        int money=Integer.parseInt(value.getText().toString());
        money=money/10;
        TextView txv = (TextView) findViewById(R.id.txv);
        txv.setText("Result: "+String.valueOf(money));
    }

//    public void sayHi(View v) {
//        EditText name = (EditText) findViewById(R.id.name);
//        TextView txv = (TextView) findViewById(R.id.txv);
//        txv.setTextSize(30);
//        txv.setText(name.getText().toString()+", Welcome to COMP4521!");
//    }
}
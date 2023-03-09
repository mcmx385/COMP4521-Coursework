package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    double[] energyRate={3.1, 4.4, 13.2, 9.7, 5.1, 3.7};
    String[] exerciseType={"Walking", "Swimming", "Running", "Cycling", "Badminton", "Golf"};
    EditText weight,time;
    TextView total,txvRate;
    Spinner exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight= (EditText) findViewById(R.id.weight);
        time= (EditText) findViewById(R.id.exTime);
        total= (TextView)findViewById(R.id.total);
        txvRate= (TextView)findViewById(R.id.txvRate);
        exercises=(Spinner) findViewById(R.id.exercises);
        ArrayAdapter<String> exerciseAd = // create ArrayAdapter for exercises
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item,
                        exerciseType);
        exerciseAd.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        exercises.setAdapter(exerciseAd);
        exercises.setOnItemSelectedListener(this); // monitor item selected
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        txvRate.setText(String.valueOf(energyRate[position]));
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


    public void calculate(View v){
        // get body weight
        double w=Double.parseDouble(weight.getText().toString());
        // get exercise time
        double t=Double.parseDouble(time.getText().toString());
        int selected=exercises.getSelectedItemPosition(); // get the position
        // calculate calorie consumption
        long consumedEnergy=Math.round(energyRate[selected]*w*t);
        // display the result
        total.setText(String.format("Calorie consumed\n %d KCal", consumedEnergy));
        }
}
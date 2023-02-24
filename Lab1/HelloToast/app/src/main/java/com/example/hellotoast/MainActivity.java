package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int count=0;
    TextView showCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount=(TextView) findViewById(R.id.showCount);
        showCount.setText(Integer.toString(count));
    }

    public void showToast(View v){
        String message=getResources().getString(R.string.toast_message)+" "+Integer.toString(count);
        Toast toast= Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
    public void countUp(View v){
        ++count;
        showCount.setText(Integer.toString(count));
    }
}
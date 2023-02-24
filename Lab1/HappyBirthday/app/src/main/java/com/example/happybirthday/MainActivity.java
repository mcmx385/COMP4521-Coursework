package com.example.happybirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","Happy Birthday");
        try{
            int val = 1/0;
        } catch (Exception e) {
            StackTraceElement[] stackTraceElements = e.getStackTrace ();
            StringBuilder builder = new StringBuilder ();
            builder.append (e);
            builder.append ("\n");
            for (int i = 0; i < 3; i++)
            {
                builder.append (stackTraceElements[i].toString ());
                builder.append ("\n");
            }
            Log.e("MainActivity",builder.toString());
        }
    }
}
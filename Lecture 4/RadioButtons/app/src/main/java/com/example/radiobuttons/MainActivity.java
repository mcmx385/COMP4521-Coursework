package com.example.radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private RadioGroup radioGroup;
    private RadioButton rdb01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        rdb01=(RadioButton) findViewById(R.id.rdbKitty);
        rdb01.setChecked(true);
        image=(ImageView) findViewById(R.id.imageView);
        radioGroup.setOnCheckedChangeListener(listener);
    }

    private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId){
            if(checkedId==rdb01.getId())
                image.setImageResource(R.drawable.kitty2);
            else
                image.setImageResource(R.drawable.puppy2);
        }
    };
}
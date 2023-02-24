package com.example.imagebuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton imgBtn1, imgBtn2;
    private boolean flip1, flip2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtn1=(ImageButton) findViewById(R.id.imgBtn1);
        imgBtn2=(ImageButton) findViewById(R.id.imgBtn2);

        imgBtn1.setOnClickListener(iBtn1);
        imgBtn2.setOnClickListener(iBtn2);

        flip1=false;
        flip2=false;
    }
    private View.OnClickListener iBtn1 = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            if (!flip1)
                imgBtn1.setImageResource(R.drawable.chung);
            else
                imgBtn1.setImageResource(R.drawable.back);
            flip1=!flip1;
        }
    };
    private View.OnClickListener iBtn2 = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            if(!flip2)
                imgBtn2.setImageResource(R.drawable.fat);
            else
                imgBtn2.setImageResource(R.drawable.back);
            flip2=!flip2;
        }
    };
}
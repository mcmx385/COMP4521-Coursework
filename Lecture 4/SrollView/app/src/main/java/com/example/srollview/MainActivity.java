package com.example.srollview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int[] myImageViews ={
            R.id.imageView1,
            R.id.imageView2,
            R.id.imageView3,
            R.id.imageView4,
            R.id.imageView5,
            R.id.imageView6,
    };

    private ImageView[] imageView=new ImageView[myImageViews.length];

    private int[] myImageDrawables = {
            R.drawable.antman,
            R.drawable.guiltyconscience,
            R.drawable.somedayoroneday,
            R.drawable.suzume,
            R.drawable.titanic,
            R.drawable.wherethewindblow
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0; i<myImageViews.length; ++i){
            imageView[i]=(ImageView) findViewById(myImageViews[i]);
            imageView[i].setImageResource(myImageDrawables[i]);
            imageView[i].setTag(i+1);
            imageView[i].setOnClickListener(showToast);
        }
    };

    private View.OnClickListener showToast = new View.OnClickListener(){
        public void onClick(View v){
            Toast.makeText(MainActivity.this, "Movie Number "+v.getTag(), Toast.LENGTH_SHORT).show();
        }
    };
}
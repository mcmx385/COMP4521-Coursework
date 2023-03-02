package com.example.flipcards;

import static java.lang.Math.floor;
import static java.lang.Math.round;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean flipped=false;
    String[] suits={"clubs","diamonds","hearts","spades"};
    boolean red=true;

    int evens=0;
    int odds=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("CW2");
        printScore();
    }

    private void printScore(){
        TextView scoreView= (TextView) findViewById(R.id.scoreView);
        scoreView.setText("Even: "+Integer.toString(evens)+"\n"+"Odd: "+Integer.toString(odds));
    }

    public void buttonHandler(View v){
        ImageButton imgBtn = (ImageButton) findViewById(R.id.cardButton);
        TextView scoreView= (TextView) findViewById(R.id.scoreView);
        if (!flipped){
            int suit=(int) (floor(Math.random()*4));
            String suitchar=suits[suit];
            int num= (int) (floor(Math.random()*3)+10);
            String numchar = Integer.toString(num);
            if (num>9){
                if(num==10)
                    numchar="jack";
                if(num==11)
                    numchar="queen";
                if(num==12)
                    numchar="king";
            }
            if(num%2==0)
                evens++;
            else
                odds++;
            printScore();
            String variant="";
            if(Math.random()>=0.5)
                variant="2";
            String res=numchar+"_of_"+suitchar+variant;
            Log.d("MainActivity",res);
            int resId=getResources().getIdentifier(res,"drawable",this.getPackageName());
            Log.d("MainActivity",Integer.toString(resId));
            imgBtn.setImageResource(resId);
        }
        else {
            if(red)
                imgBtn.setImageResource(R.drawable.back2);
            else
                imgBtn.setImageResource(R.drawable.back);
            red=!red;
        }
        flipped=!flipped;
    }
}
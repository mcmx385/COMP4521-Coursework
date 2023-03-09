package com.example.classwork3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private RadioGroup radioGroup;
    private int[] ids = {R.id.radioButton,R.id.radioButton2,R.id.radioButton3,R.id.radioButton4};
    int checked=4;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=(ImageView) findViewById(R.id.imageView);
        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        RadioButton rdb4= (RadioButton) findViewById (R.id.radioButton4);
        rdb4.setChecked(true);
        radioGroup.setOnCheckedChangeListener(listener);
        editText=(EditText) findViewById(R.id.editTextTextPersonName);
    }

    private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId){
            Log.d("MainActivity","changed radio button");
            for(int i=0; i<ids.length; ++i)
                if(checkedId==ids[i]) {
                    if (i >= 2)
                        image.setImageResource(R.drawable.smile);
                    else
                        image.setImageResource(R.drawable.sad);
                    checked=i+1;
                }
        }
    };

    public void onSubmit(View v){
        String name = editText.getText().toString();
        Log.d("MainActivity",name);
        Log.d("MainActivity",Integer.toString(checked));
        TextView resultText = (TextView) findViewById(R.id.textView4);
        resultText.setText("Thank you for your feedback to "+name);
    }
}
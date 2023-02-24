package com.example.checkboxs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registerCourse(View v) {
        CheckBox chkbox;
        String msg="";

        int[] ids = {R.id.ckb1,R.id.ckb2,R.id.ckb3,R.id.ckb4};
        for(int i=0; i<ids.length; ++i){
            chkbox=(CheckBox) findViewById(ids[i]);
            if(chkbox.isChecked())
                msg+="\n"+chkbox.getText();
        }
        if(msg.length()>0)
            msg="Your registered course list is: "+msg;
        else
            msg="No Courses are registered!";
        TextView result=findViewById(R.id.displayResult);
        result.setText(msg);
    }
}
package com.example.ejerradiobutoncolores;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioAzul,radioRed,rAdioGreen;
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=(TextView) findViewById(R.id.textView);
        radioAzul=(RadioButton)findViewById(R.id.RadioBlue);
        radioRed=(RadioButton)findViewById(R.id.RadioRed);
        rAdioGreen=(RadioButton)findViewById(R.id.RadioGreen);
    }


    public void clik(View v){


        if(radioRed.isChecked()){
            tv1.setBackgroundColor(Color.RED);
        }if(radioAzul.isChecked()){
            tv1.setBackgroundColor(Color.BLUE);
        }if(rAdioGreen.isChecked()){
            tv1.setBackgroundColor(Color.GREEN);
        }



    }

}

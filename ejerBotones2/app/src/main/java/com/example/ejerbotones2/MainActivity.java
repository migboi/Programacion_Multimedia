package com.example.ejerbotones2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private ImageButton bor,boa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView);
        bor=(ImageButton)findViewById(R.id.ButtonRed);
        boa=(ImageButton)findViewById(R.id.ButtonBlue);

    }

    public void onclik(View view){

        switch (view.getId()){

            case R.id.ButtonRed:
                tv1.setBackgroundColor(Color.RED);
                break;

            case R.id.ButtonBlue:
                tv1.setBackgroundColor(Color.BLUE);
                break;
        }
    }
}

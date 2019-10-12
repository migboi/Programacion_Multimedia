package com.example.holamundo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    private EditText ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ed3=(EditText)findViewById(R.id.ed3);

        String dato=getIntent().getStringExtra("dato");
        ed3.setText(dato);

    }

    public void anterior(View view){

        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);

    }
}

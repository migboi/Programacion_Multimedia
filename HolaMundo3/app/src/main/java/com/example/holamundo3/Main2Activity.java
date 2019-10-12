package com.example.holamundo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private EditText et1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et1=(EditText)findViewById(R.id.ed2);

    }

    public void Sig(View view){

        Intent i=new Intent(this,Main3Activity.class);
        i.putExtra("dato",et1.getText().toString());
       startActivity(i);

    }

}

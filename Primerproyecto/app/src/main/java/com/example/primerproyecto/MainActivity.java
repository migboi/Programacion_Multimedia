package com.example.primerproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText minombre;
    private TextView misaludo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        misaludo = findViewById(R.id.text2);
        minombre=findViewById(R.id.edit1);
    }

    public void saludar(View view){

        String saludo="hola "+ minombre.getText().toString();
        misaludo.setText(saludo);


    }

}

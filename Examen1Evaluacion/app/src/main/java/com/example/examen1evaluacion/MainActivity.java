package com.example.examen1evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView Pati;
    private ImageView bici;
    private ImageView coche;
    private ImageView selecion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pati=findViewById(R.id.img_11);
        bici=findViewById(R.id.img_12);
        coche=findViewById(R.id.img_13);





    }





    public void onClikBici(View view){


        startActivity(new Intent(this,Main2Activity.class));


    }


    public void onClikPati(View view){


        startActivity(new Intent(this,Main2Activity.class));


    }
}

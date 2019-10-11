package com.example.ejemploslayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lineal(View view){
        startActivity(new Intent(this,ActivityLineal.class));

    }

    public void tabla(View view){
        startActivity(new Intent(this,ActivityTabla.class));

    }

    public void Relativo(View view){
        startActivity(new Intent(this,ActivityRelativo.class));

    }

        public void Grid(View view){

            startActivity(new Intent(this,ActivityGrid.class));

        }

}

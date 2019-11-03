package com.example.spinnerobjetos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=(Spinner)findViewById(R.id.spinner);
        cargaSpiner();
    }

    private void cargaSpiner(){
        ArrayList<MiModelo> lista=new ArrayList<MiModelo>();
        lista.add(new MiModelo(1,"valor 1"));
        lista.add(new MiModelo(2,"valor 2"));
        lista.add(new MiModelo(3,"valor 3"));

        ArrayAdapter<MiModelo> adapter=new ArrayAdapter<MiModelo>(this,R.layout.support_simple_spinner_dropdown_item,lista);
        spinner.setAdapter(adapter);
    }
}

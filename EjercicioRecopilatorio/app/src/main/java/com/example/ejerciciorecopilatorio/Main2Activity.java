package com.example.ejerciciorecopilatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView mizona;
    private TextView mitarifa;
    private TextView mitipo;
    private TextView mipeso;
    private TextView miprecio;
    private Regalo reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mizona=(TextView)findViewById(R.id.textZonat);
        mitarifa=(TextView)findViewById(R.id.textTarifa);
        mitipo=(TextView)findViewById(R.id.textTipo);
        mipeso=(TextView)findViewById(R.id.textPeso);
        miprecio=(TextView)findViewById(R.id.textPrecio);

        reg=(Regalo)getIntent().getSerializableExtra("objeto");

        mizona.setText(reg.getZona());
        mitarifa.setText(reg.getTarifa());
        mitipo.setText(reg.getTipo());
        mipeso.setText(String.valueOf(reg.getPeso()));
        miprecio.setText(String.valueOf(reg.getPrecio()));
    }




}

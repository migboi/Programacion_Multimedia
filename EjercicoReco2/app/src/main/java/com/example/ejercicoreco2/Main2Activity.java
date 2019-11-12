package com.example.ejercicoreco2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView texZona;
    private TextView texTarida;
    private TextView texTipo;
    private TextView texPeso;
    private TextView texPrecio;
    private paquete per;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        texZona=findViewById(R.id.textViewZona);
        texTarida=findViewById(R.id.textViewTarifa);
        texTipo=findViewById(R.id.textViewTipo);
        texPeso=findViewById(R.id.textViewPes);
        texPrecio=findViewById(R.id.textViewPreci);

        per=(paquete)getIntent().getSerializableExtra("objeto");

        texZona.setText(per.getZona());
        texTarida.setText(per.getTarifa());
        texTipo.setText(per.getTipo());
        texPeso.setText(per.getPeso());
        texPrecio.setText(per.getPrecio().toString());
;    }
}

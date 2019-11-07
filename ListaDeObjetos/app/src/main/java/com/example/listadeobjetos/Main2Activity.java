package com.example.listadeobjetos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    private TextView texNombre;
    private  TextView texApellido;
    private TextView texEdad;
    private TextView texPais;
    private Persona per;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        texNombre=(TextView)findViewById(R.id.textNombre);
        texApellido=(TextView)findViewById(R.id.textApellido);
        texEdad=(TextView)findViewById(R.id.textEdad);
        texPais=(TextView)findViewById(R.id.textPais);

        per=(Persona)getIntent().getSerializableExtra("objeto");
        // System.out.println(per.toString());
        texNombre.setText(per.getNombre());
        texApellido.setText(per.getApellido());
        texEdad.setText(String.valueOf(per.getEdad()));
        texPais.setText(per.getPais());


    }
}

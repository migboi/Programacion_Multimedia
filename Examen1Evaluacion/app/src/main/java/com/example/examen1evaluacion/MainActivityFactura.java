package com.example.examen1evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivityFactura extends AppCompatActivity {


    private TextView mimodelo;
    private TextView miExtra;
    private TextView miDias;
    private TextView miSeguro;
    private TextView miCoste;
    private Trasporte T;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_factura);


        mimodelo=findViewById(R.id.textViewModelo);
        miExtra=findViewById(R.id.textViewExtra);
        miSeguro=findViewById(R.id.textViewSeguro);
        miCoste=findViewById(R.id.textViewCoste);



        T=(Trasporte)getIntent().getSerializableExtra("objeto");
        mimodelo.setText(T.getTrasporte());
        miExtra.setText(T.getExtra());
       miSeguro.setText(T.getSeguro());
       miCoste.setText(T.getPrecio());
    }
}

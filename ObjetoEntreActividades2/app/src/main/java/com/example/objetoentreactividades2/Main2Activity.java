package com.example.objetoentreactividades2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    protected TextView miNom;
    protected TextView miApe;
    protected TextView miEd;
    protected ImageView mifoto;
    protected TextView datosPersona;
    protected Persona per;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        miNom= (TextView) findViewById(R.id.campoNom);
        miApe= (TextView) findViewById(R.id.campoApe);
        miEd =(TextView) findViewById(R.id.campoEd);
        mifoto =(ImageView)findViewById(R.id.campoFoto);
        datosPersona = (TextView) findViewById(R.id.todaPersona);

        per=(Persona)getIntent().getSerializableExtra("CLAVEper");
        datosPersona.setText(per.toString());
        Toast.makeText(this,per.toString(), Toast.LENGTH_LONG).show();

        miNom.setText("NOMBRE: "+ per.getNombre());
        miApe.setText("APELLIDO: "+ per.getApellido());
        miEd.setText("EDAD: " + String.valueOf(per.getEdad()));
        mifoto.setImageResource(per.getFoto());
    }
}

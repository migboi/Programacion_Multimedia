package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre;
    private EditText et_datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre=(EditText)findViewById(R.id.txt_numero);
        et_datos=(EditText)findViewById(R.id.txt_datos);



    }


    public void guardar(View view){

        String nombre=et_nombre.getText().toString();
        String datos=et_datos.getText().toString();

        SharedPreferences preferencia=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor=preferencia.edit();
        obj_editor.putString(nombre,datos);
        obj_editor.commit();

        Toast.makeText(this,"El contacto se ha gurdado",Toast.LENGTH_LONG).show();

    }

    public void buscar(View view){
        String nombre=et_nombre.getText().toString();
        SharedPreferences preferencia=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos=preferencia.getString("nombre","");

        if(datos.length()==0){
            Toast.makeText(this,"No se ha encontadao nada",Toast.LENGTH_LONG).show();
        }else{

            et_datos.setText(datos);
        }


    }
}

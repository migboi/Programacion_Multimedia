package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Spinner miSpiner;

    final static String semana[]={"Lunes","Martes","Miercoles","jueves","Viernes","Sabado","Domingo"};




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mensage;
        miSpiner=(Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> miAdaptador=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,semana);
        miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        miSpiner.setAdapter(miAdaptador);

        miSpiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
             String mensage="";
             mensage="Item clicked =>"+semana[position];
             showToast(mensage);

            }
            public void onNothingSelected(AdapterView<?> adapterView){

            }
        });
    }
    public void showToast(String text){
        Toast.makeText(this, text,Toast.LENGTH_LONG).show();
    }
}

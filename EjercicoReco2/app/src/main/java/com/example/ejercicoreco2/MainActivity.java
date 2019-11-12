package com.example.ejercicoreco2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {


    private ListView lv;
    private RadioButton RUrgente;
    private RadioButton Rnormal;

    private CheckBox Cregalo;
    private CheckBox Ctargeta;
    private EditText edPeso;



    private String zona;
    private String tarifa;
    private String tipo;
    private String peso;

    private double precio;
    private paquete pac;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.ListaView);
        RUrgente=findViewById(R.id.radioButtonUrgente);
        Rnormal=findViewById(R.id.radioButtonNormal);
        Cregalo=findViewById(R.id.checkBoxRegalo);
        Ctargeta=findViewById(R.id.ChechBoxTArgeta);
        edPeso=findViewById(R.id.editTextPeso);
        cargarLista();



    }

    private void cargarLista(){

        final String lista[]={"Zona A Europa 10","Zona B Asia 20","Zona C America 30"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.lista,lista);
        lv.setAdapter(adapter);
       ;

          lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  zona=lista[position].toString();


              }
          });
    }

    private void Radio(){

        if(zona.equalsIgnoreCase("Zona A Europa 10")){
            precio=10;
        }if(zona.equalsIgnoreCase("Zona B Asia 20")){
            precio=20;
        }if(zona.equalsIgnoreCase("Zona C America 30")){
            precio=60;
        }

        if(RUrgente.isChecked()){
            tarifa=RUrgente.getText().toString();
            precio=precio*1.3;

        }if(Rnormal.isChecked()){
            tarifa=Rnormal.getText().toString();
            precio=precio*1.3;
        }

    }

    public void check(){

        if(Ctargeta.isChecked()){

            tipo=Ctargeta.getText().toString();
        }if(Cregalo.isChecked()){

            tipo=Cregalo.getText().toString();
        }if(Ctargeta.isChecked() && Cregalo.isChecked()){

            tipo=Ctargeta.getText().toString()+" y "+Cregalo.getText().toString();
        }
    }


    public void Onclick(View view){

        Radio();
        check();
        peso=edPeso.getText().toString();




        pac =new paquete(zona,tarifa,tipo,peso,precio);
        System.out.println(pac.toString());
        System.out.println(pac.toString());

        Intent miIntent=new Intent(this,Main2Activity.class);
        Bundle miBundle=new Bundle();
        miBundle.putSerializable("objeto",pac);
        miIntent.putExtras(miBundle);
        startActivity(miIntent);
    }

    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==R.id.MenuCanvas){
            startActivity(new Intent(this,Main3Activity.class));

        } else if(id==R.id.MenuSalir){

            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }






}

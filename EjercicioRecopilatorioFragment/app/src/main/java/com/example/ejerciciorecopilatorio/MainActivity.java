package com.example.ejerciciorecopilatorio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spi;
    private RadioButton Rurgente;
    private RadioButton RNormal;
    private CheckBox Cregalo;
    private CheckBox Ctargeta;
    private EditText peso;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spi=(Spinner)findViewById(R.id.spinner);
        Rurgente=findViewById(R.id.radioUrg);
        RNormal=findViewById(R.id.radioNor);
        Cregalo=findViewById(R.id.checkReg);
        Ctargeta=findViewById(R.id.CheckTarjeta);
        peso=(EditText) findViewById(R.id.ed_Peso);
        btn=(Button)findViewById(R.id.button);

        cargarSpiner();






    }




    public void boton(View view){

        String tarifa;
        String tipo="";
        int pes;
        double total=0;


        //campura item spiner
       tarifa=spi.getSelectedItem().toString();
       int posit=spi.getSelectedItemPosition();


        switch (spi.getSelectedItemPosition()){
            case 0:
                total=total+30;
                break;

            case 1:
                total=total+20;
                break;

            case 2:
                total=total+10;
                break;
            default:
                Toast.makeText(this,"Error al pasar al captura item",Toast.LENGTH_SHORT).show();

        }







        //check buton

        if(Cregalo.isChecked() && !Ctargeta.isChecked()){
            tipo=Cregalo.getText().toString();

        } if(Ctargeta.isChecked() && !Cregalo.isChecked() ){
            tipo=Ctargeta.getText().toString();

        } if(Cregalo.isChecked() && Ctargeta.isChecked()){
            tipo=Cregalo.getText().toString()+" y "+Ctargeta.getText().toString();

        }
        //AQUI el peso

        String p=peso.getText().toString();

        pes=Integer.parseInt(p);



        //radio buton



        if(pes<6){
            total=total+(pes*1);
        }if(pes>6 && pes<10){
            total=total+(pes*1.5);
        }if(pes>10){
            total=total+(pes*2);
        }

        if(Rurgente.isChecked()){
            tarifa=Rurgente.getText().toString();
            total=total*1.30;

        }else if(RNormal.isChecked()){
            tarifa=RNormal.getText().toString();

        }

        System.out.println("El precio es "+total);

        Regalo regalo=new Regalo(spi.getSelectedItem().toString(),tarifa,tipo,pes,total);
        System.out.println(regalo.toString());







        //pasar objeto a segunda activity

       /* Intent miIntent=new Intent(this,Fragment1.class);
        Bundle miBundle=new Bundle();
        miBundle.putSerializable("objeto",regalo);
        miIntent.putExtras(miBundle);
        startActivity(miIntent);*/

       Fragment1 fragment1=new Fragment1();

        Bundle miBundle=new Bundle();
        miBundle.putSerializable("objeto",regalo);
        fragment1.setArguments(miBundle);

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.principal,fragment1,null);
        fragmentTransaction.commit();


        spi.setVisibility(view.INVISIBLE);
        Rurgente.setVisibility(view.INVISIBLE);
        RNormal.setVisibility(view.INVISIBLE);
        Cregalo.setVisibility(view.INVISIBLE);
        Ctargeta.setVisibility(view.INVISIBLE);
        peso.setVisibility(view.INVISIBLE);
        btn.setVisibility(view.INVISIBLE);


    }

    //ocultar y mostrat el menu

    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.over,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==R.id.item1){

            Toast.makeText(this,"Opcion 1", Toast.LENGTH_SHORT).show();
        } else if(id==R.id.item2){

            Toast.makeText(this,"Opcion 2",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    //Spiner Objeto

    private void cargarSpiner(){
        ArrayList<MiObjeto> lista=new ArrayList<MiObjeto>();
        lista.add(new MiObjeto("Zona A","Asia y Oceania",30));
        lista.add(new MiObjeto("Zona B","Ameria y Africa",20));
        lista.add(new MiObjeto("Zona C","Europa",10));

        ArrayAdapter<MiObjeto> adapter=new ArrayAdapter<MiObjeto>(this,R.layout.spinner,lista);
        spi.setAdapter(adapter);


    }

}
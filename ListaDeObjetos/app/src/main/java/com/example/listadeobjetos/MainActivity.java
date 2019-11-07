package com.example.listadeobjetos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;
    private Persona objeto;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=(TextView)findViewById(R.id.tv1);
        lv1=(ListView)findViewById(R.id.lv1);
        cargarLista();
    }

    private void cargarLista(){
        final ArrayList<Persona> list=new ArrayList<Persona>();
        list.add(new Persona("Miguel","López",31,"Valencia"));
        list.add(new Persona("Mireia","Tormo",25,"Valencia"));
        list.add(new Persona("Oliver","López",6,"Francia"));
        list.add(new Persona("Cleo","López",3,"España"));
        list.add(new Persona("Berto","Romero",44,"España"));
        list.add(new Persona("Andreu","BuenaFuente",58,"España"));
        list.add(new Persona("Vicente","López",61,"Sumacarcer"));
        list.add(new Persona("M elisa","Boils",56,"Sumacarcer"));
        list.add(new Persona("Lidia","López",26,"Sumacarcer"));

        ArrayAdapter<Persona> adapter=new ArrayAdapter<Persona>(this,R.layout.list_item,list);
        lv1.setAdapter(adapter);

        //clase aninima para hacer clic new Oin y autocompletar
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               objeto= list.get(position);
                    pasarA();
            }
        });


    }

    private void pasarA(){







        Intent miIntent=new Intent(this,Main2Activity.class);
        Bundle miBundle=new Bundle();
        miBundle.putSerializable("objeto",objeto);
        miIntent.putExtras(miBundle);
        startActivity(miIntent);

       // startActivity(new Intent(this,Main2Activity.class));
    }





}

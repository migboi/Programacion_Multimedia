package com.example.fragmentsinicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button btnuno;
    Button btndos;
    LinearLayout contenedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnuno=(Button)findViewById(R.id.btn1);
        btndos=(Button)findViewById(R.id.btn2);
        contenedor=(LinearLayout) findViewById(R.id.LayaiutContenedor);




        btnuno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                interfaz1 Fragmento1=new interfaz1();

                FragmentManager manager=getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.LayaiutContenedor,Fragmento1).commit();

            }
        });

        btndos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                interfaz2 Fragmento2=new interfaz2();

                FragmentManager manager=getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.LayaiutContenedor,Fragmento2).commit();

            }
        });
    }
}

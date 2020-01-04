package com.example.fragmentodinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , Fragment1.OnFragmentInteractionListener {

    Button boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton1=findViewById(R.id.btn1);
        boton1.setOnClickListener(this);



      /*  boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });*/


    }


    @Override
    public void onClick(View v) {

    FragmentManager fragmentManager=getSupportFragmentManager();
    FragmentTransaction transaction=fragmentManager.beginTransaction();
    Fragment1 fragment1=new Fragment1();
    transaction.add(R.id.princial,fragment1);
    transaction.commit();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

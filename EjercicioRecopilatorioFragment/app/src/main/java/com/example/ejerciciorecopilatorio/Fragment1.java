package com.example.ejerciciorecopilatorio;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {


    TextView mizona;
    TextView mitarifa;
    TextView mitipo;
    TextView mipeso;
    TextView miprecio;
    Regalo reg;
    Button atras;
    Activity activity;

    public Fragment1() {
        // Required empty public constructor

    }

    public void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if(getArguments() !=null){
            reg=(Regalo)getArguments().getSerializable("objeto");
        }

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragment1,container,false);

        mizona=(TextView) view.findViewById(R.id.textZonat);
        mitarifa=(TextView)view.findViewById(R.id.textTarifa);
        mitipo=(TextView)view.findViewById(R.id.textTipo);
        mipeso=(TextView)view.findViewById(R.id.textPeso);
        miprecio=(TextView)view.findViewById(R.id.textPrecio);

       reg=(Regalo)getArguments().getSerializable("objeto");

        mizona.setText(reg.getZona());
        mitarifa.setText(reg.getTarifa());
        mitipo.setText(reg.getTipo());
        mipeso.setText(String.valueOf(reg.getPeso()));
        miprecio.setText(String.valueOf(reg.getPrecio()));

        //return inflater.inflate(R.layout.fragment_fragment1,container,false);


        return view;


    }


    public void onclick(View view){
        activity=getActivity();
        Intent anterior=new Intent(activity,MainActivity.class);
        startActivity(anterior);
    }







}

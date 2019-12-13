package com.example.fragmentoconboton;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.FragmentTransaction;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public Fragment mFrg;
    int mStackPosition=1;
    Button manejarFragment;
    int dibujos[]={R.drawable.ic_i,R.drawable.ic_gato,R.drawable.ic_gato2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manejarFragment=(Button)findViewById(R.id.botonprueba);
        manejarFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });

        if(savedInstanceState==null){
            MiFragment miFragment=MiFragment.newInstance(dibujos[0]);

            FragmentTransaction ft=getFragmentManager().beginTransaction();
            ft.add(R.id.miFrg,miFragment);
            ft.commit();
        }else{
            mStackPosition=savedInstanceState.getInt("position");
        }
    }

    @SuppressLint("WrongConstant")
    public  void addFragment(){

        MiFragment miFragment;
        Random r=new Random();
        miFragment =MiFragment.newInstance(dibujos[r.nextInt(dibujos.length)]);
        FragmentTransaction ft=getFragmentManager().beginTransaction();

        ft.replace(R.id.miFrg, miFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        ft.addToBackStack(null);
        ft.commit();


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistableState){
        super.onSaveInstanceState(outState,outPersistableState);
        outState.putInt("position",mStackPosition);
    }
}

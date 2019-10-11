package com.example.image1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


        private ImageButton ibline,ibgrid,ibtable,ibrelative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibline=findViewById(R.id.ButtonLIne);
        ibgrid=findViewById(R.id.ButtonGrid);
        ibtable=findViewById(R.id.ButtonTable);
        ibrelative=findViewById(R.id.ButtonRelative);
    }


    public void onclick(View view){

        switch (view.getId()){

            case R.id.ButtonLIne:
                startActivity(new Intent(this,ActivityLinear.class));

            case R.id.ButtonTable:
                startActivity(new Intent(this,TableActivity.class));

            case R.id.ButtonRelative:
                startActivity(new Intent(this,RelativeActivity.class));

            case R.id.ButtonGrid:
                startActivity(new Intent(this,GridActivity.class));

        }
    }



}

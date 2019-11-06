package com.example.diferentestiposdeeventos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn=(Button)this.findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pulsado boton Uno", Toast.LENGTH_SHORT).show();
            }} );
    }

    public void mio(View v){
        Toast.makeText(MainActivity.this, "Pulsado boton dos", Toast.LENGTH_SHORT).show();
    }


}

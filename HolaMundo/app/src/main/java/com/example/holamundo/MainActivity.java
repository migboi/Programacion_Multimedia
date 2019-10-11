package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ed1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //metodo boton

    public void Siguente(View view){

        ed1=findViewById(R.id.ed1);

        Intent siguente=new Intent(this,SegundaActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("texto", ed1.getText().toString());
        siguente.putExtra("bundle",bundle);
        startActivity(siguente);


    }
}

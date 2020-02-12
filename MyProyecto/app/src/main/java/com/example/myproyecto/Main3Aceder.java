package com.example.myproyecto;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Aceder extends AppCompatActivity {
    DatabaseHelper mydb= null;

    EditText edmail;
    EditText edPass;
    Button bac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mydb=new DatabaseHelper(this);
        edmail=(EditText)findViewById(R.id.editTextEma);
        edPass=(EditText)findViewById(R.id.editTextPasss);
        bac=(Button)findViewById(R.id.bAcederStudents);
        buscar();
    }


    public void buscar(){

        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res= mydb.getListarUser();

                if(res.getCount()==0){
                    // mensaje
                    Toast.makeText(getApplicationContext(),"No hay neningun registro",Toast.LENGTH_SHORT).show();

                }else{

                    while (res.moveToNext()){
                        if(res.getString(0).equals(edmail.getText().toString()) & res.getString(1).equals(edPass.getText().toString())){
                            Toast.makeText(getApplicationContext(),"Emmail y password correctos",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Main2Activity.class));

                        }else{
                            Toast.makeText(Main3Aceder.this,"Emmail o password no son correctosd",Toast.LENGTH_SHORT).show();

                        }

                    }
                }

            }
        });

    }


}



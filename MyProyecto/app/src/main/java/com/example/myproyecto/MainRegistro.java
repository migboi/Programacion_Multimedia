package com.example.myproyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainRegistro extends AppCompatActivity {
    DatabaseHelper  mydb ;
    EditText e1,e2,e3;
    Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        mydb =new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.password);
        e3=(EditText)findViewById(R.id.cpass);
        but=(Button)findViewById(R.id.register2);


        but.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();

                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Los campos estan vacios",Toast.LENGTH_SHORT).show();

                }else{

                    if(s2.equals(s3) && s1.contains(".") && s1.contains("@") &&s1.length()>5 && s2.length()>5){

                        Boolean chkemail=mydb.chkemail(s1);
                        System.out.println(chkemail);

                        if(chkemail==true){

                            Boolean insert=mydb.insert(s1,s2);


                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Registro correcto",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Main2Activity.class));

                            }

                        }
                        else{
                            Toast.makeText(getApplicationContext(),"email ya existente",Toast.LENGTH_SHORT).show();

                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"Password o email incorrectos",Toast.LENGTH_SHORT).show();
                    }



                }

            }
        });


    }
}

package com.example.operacionesbasica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText num1;
    private  EditText num2;
    private ListView lv;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1=findViewById(R.id.editNum1);
        num2=findViewById(R.id.EditNum2);
        lv=findViewById(R.id.lista);
        tvResultado=findViewById(R.id.textResult);


        String operacion[]={"sumar","restar","dividir","multiplicar"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.lis,operacion);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                int numero1=0;
                int numero2=0;
                int resul=0;
                switch ((int) lv.getItemIdAtPosition(position)){

                    case 0:
                         numero1=Integer.parseInt(num1.getText().toString());
                         numero2=Integer.parseInt(num2.getText().toString());
                         resul=numero1+numero2;
                         tvResultado.setText(String.valueOf(resul));
                        break;

                    case 1:

                         numero1=Integer.parseInt(num1.getText().toString());
                         numero2=Integer.parseInt(num2.getText().toString());
                         resul=numero1-numero2;
                         tvResultado.setText(String.valueOf(resul));
                        break;

                    case 2:
                        numero1=Integer.parseInt(num1.getText().toString());
                        numero2=Integer.parseInt(num2.getText().toString());
                        resul=numero1/numero2;
                        tvResultado.setText(String.valueOf(resul));
                        break;

                    case 3:
                        numero1=Integer.parseInt(num1.getText().toString());
                        numero2=Integer.parseInt(num2.getText().toString());
                        resul=numero1*numero2;
                        tvResultado.setText(String.valueOf(resul));
                        break;

                    default:
                        System.out.println("error");


                }
            }
        });



    }



    }




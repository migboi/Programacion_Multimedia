package com.example.examen1evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {


    private Spinner spi;
    private RadioButton RadiSinSeguro;
    private RadioButton RadioConSeguro;

    private CheckBox ChecCasco;
    private CheckBox ChecGps;
    private CheckBox ChecExtra;
    private EditText EDnUMERO;
    private TextView TxPRECIO;
    private String trasporte;
    private String seguro;
    private String Extra;
    private String precio;
    private double total;

    private Trasporte tras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spi=findViewById(R.id.spinner);
        RadioConSeguro=findViewById(R.id.radioButtonSeguro);
        RadiSinSeguro=findViewById(R.id.radioButtonNoSeguro);

        ChecCasco=findViewById(R.id.checkBoxCasco);
        ChecGps=findViewById(R.id.checkBoxGps);
        ChecExtra=findViewById(R.id.checkBoxExtras);
        EDnUMERO=findViewById(R.id.editTextNumero);
        TxPRECIO=findViewById(R.id.textView2);

        cargarSpiner();

    }





    //ocultar y mostrat el menu he añadido la opcion de salir

    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==R.id.item1){

           System.exit(0);
        } else if(id==R.id.item2){

            startActivity(new Intent(this,MainActivityCopiRight.class));
        }if(id==R.id.item3){

            startActivity(new Intent(this,MainActivityAyuda.class));
        } else if(id==R.id.item4){

            startActivity(new Intent(this,MainActivityDibujo.class));
        }
        return super.onOptionsItemSelected(item);
    }

    //CARGA EL SPINER

    private void cargarSpiner(){

        final String Bici[]={"Paseo Orbea 15","Ciudad Cube 20","Montaña Bike 25"};

        ArrayAdapter<String> miAdaptador=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,Bici);
        miAdaptador.setDropDownViewResource(R.layout.spiner);
        spi.setAdapter(miAdaptador);

        spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                trasporte=Bici[position].toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void Boton(View view){

        if(trasporte.equalsIgnoreCase("Paseo Orbea 15")){
            total=15;
        }if(trasporte.equalsIgnoreCase("Ciudad Cube 20")){
            total=20;
        }if(trasporte.equalsIgnoreCase("Montaña Bike 25")){
            total=25;
        }

        if(ChecCasco.isChecked()){
            total=total+50;
            Extra=ChecCasco.getText().toString();
        }if(ChecGps.isChecked()){
            total=total+50;
            Extra=ChecGps.getText().toString();
        }if(ChecExtra.isChecked()){
            total=total+50;
            Extra=ChecExtra.getText().toString();
        }

        if(RadioConSeguro.isChecked()){
            total=total*1.2;
            seguro=RadioConSeguro.getText().toString();
        }if(RadiSinSeguro.isChecked()){
            seguro=RadiSinSeguro.getText().toString();
        }

       int n=Integer.parseInt(EDnUMERO.getText().toString());
        total=total*n;
        precio=String.valueOf(total);


        TxPRECIO.setText(precio);
        tras=new Trasporte(trasporte,seguro,Extra,precio);
        System.out.println(tras.toString());
    }


    public void PasarAFactura(View view){

        Intent miIntent=new Intent(this,MainActivityFactura.class);
        Bundle miBundle=new Bundle();
        miBundle.putSerializable("objeto",tras);
        miIntent.putExtras(miBundle);
        startActivity(miIntent);

    }

}



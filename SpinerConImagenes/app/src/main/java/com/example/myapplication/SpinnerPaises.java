package com.example.myapplication;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SpinnerPaises extends AppCompatActivity {

    private ArrayList<CountryItem> mCountryList;
    private CountryAdapter mAdapter;
    private Spinner spinerCountries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();

        spinerCountries = findViewById(R.id.spiner_countries);

        mAdapter=new CountryAdapter(this,mCountryList);
        spinerCountries.setAdapter(mAdapter);

        spinerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                CountryItem clickedItem=(CountryItem) parent.getItemAtPosition(position);
                String clickCountryName=clickedItem.getmCountryName();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    private void initList(){
        mCountryList = new ArrayList<>();
        mCountryList.add(new CountryItem("India", R.drawable.ic_india));
        mCountryList.add(new CountryItem("China", R.drawable.ic_china));
        mCountryList.add(new CountryItem("USA", R.drawable.ic_usa));
        mCountryList.add(new CountryItem("Germany", R.drawable.ic_germay));
        mCountryList.add(new CountryItem("Spain",R.drawable.ic_sapin));
        mCountryList.add(new CountryItem("URS",R.drawable.ic_urs));

    }


   public void Ckick(View v){
       String info="";
        int num=spinerCountries.getSelectedItemPosition();
       String numero=String.valueOf(num);

       switch (spinerCountries.getSelectedItemPosition()){

           case 0:
               info="es un país soberano ubicado en el sur de Asia. Con sus más" +
                       " de 1372 millones de habitantes, es el segundo país del mundo por población ―después " +
                       "de la República Popular China (con 1395 millones). ";

               break;
           case 1:
               info="La República Popular China (en chino simplificado: 中华人民共和国 y en pinyin: Zhōnghuá Rénmín Gònghéguó), " +
                       "o simplemente China (en chino simplificado: 中国 y en pinyin: Zhōngguó), " +
                       "es un Estado soberano situado en Asia Oriental. Es el país más poblado del mundo, con 1395 millones " +
                       "de habitantes, y la primera potencia económica mundial por PIB, en términos de paridad " +
                       "de poder adquisitivo";
               break;

           case 2:
               info="Estados Unidosnota 2\u200B (en inglés, United States, cuya abreviatura en español es EE. UU.),nota 3\u200B " +
                       "oficialmente Estados Unidos de América (United States of America, cuya sigla oficial en inglés es USA y " +
                       "su contraparte en español es EUA),10\u200B es un país soberano constituido en república federal " +
                       "constitucional compuesta por cincuenta estados y un distrito federal. La mayor parte del país se ubica en el " +
                       "medio de América del Norte";
               break;
           case 3:
               info="Alemania (en alemán: Deutschland), oficialmente República Federal de Alemania (en alemán: Bundesrepublik Deutschland, " +
                       "Acerca de este sonido pronunciación (?·i), /ˈbʊndəsrepubliːk ˈdɔʏʧlant/), es un país soberano centroeuropeo, miembro de la" +
                       " Unión Europea, constituido en Estado social y democrático de derecho y cuya forma de gobierno es la república parlamentaria y federal.";
               break;
           case 4:
               info="España, también denominado Reino de España,nota 1\u200B es un país transcontinental, miembro de la Unión Europea, constituido en Estado social y " +
                       "democrático de derecho y cuya forma de gobierno es la monarquía parlamentaria. ";
               break;
           case 5:
               info="La Revolución de Febrero de 1917, que provocó la caída del Imperio ruso, tuvo como sucesor al Gobierno provisional ruso, que fue derrocado por la " +
                       "Revolución de Octubre, estableciéndose el Gobierno de los bolcheviques denominado Sovnarkom. ";
               break;


       }

       Intent inte=new Intent(this,Main2Activity.class);
       inte.putExtra("dato",info);
       inte.putExtra("nume",numero);
       startActivity(inte);

   }





}

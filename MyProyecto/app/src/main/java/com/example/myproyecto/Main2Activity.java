package com.example.myproyecto;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    DatabaseHelper mydb;

    EditText editName,editSurname,editMarks,editTextId;
    Button buttonAdd;
    Button butListar;
    Button butUp;
    Button butDel;
    Button butBus;

    RadioButton Rmas;
    RadioButton Rfen;
    String  edad="";

    RadioGroup grupsexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mydb=new DatabaseHelper(this);

        editName=(EditText) findViewById(R.id.editText_name);
        editSurname=(EditText) findViewById(R.id.editText_surname);
        editMarks=(EditText) findViewById(R.id.editText_mark);
        editTextId=(EditText) findViewById(R.id.editText_id);

        buttonAdd=(Button) findViewById(R.id.butInsert);
        butListar=(Button)findViewById(R.id.button_listar);
        butUp=(Button)findViewById(R.id.button3_Up);
        butDel=(Button)findViewById(R.id.button_delete);
        butBus=(Button)findViewById(R.id.button_bus);



        Rmas=(RadioButton)findViewById(R.id.radioButtonMas);
        Rfen=(RadioButton)findViewById(R.id.radioButtonFem);

        grupsexo=(RadioGroup) findViewById(R.id.radioGrupSexo);



        AddDate();
        Listar();
        UpdateBase();
        Delete();
        buscar();


    }


    //boton insertar
    public void AddDate(){ String sexo = null;


        // System.out.println(sexo+"************************************************");

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sexo = null;
                if(Rmas.isChecked()){

                    sexo="masculino";
                }if(Rfen.isChecked()){
                    sexo="femenino";
                }
                boolean isInserted= mydb.insertData(editName.getText().toString(),editSurname.getText().toString(), editMarks.getText().toString(),sexo);

                if(isInserted=true){
                    Toast.makeText(Main2Activity.this,"Insertado",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Main2Activity.this,"No se inserto",Toast.LENGTH_SHORT).show();
                }
                editName.setText("");
                editSurname.setText("");
                editMarks.setText("");
                editTextId.setText("");

            }
        });

    }

    // boton
    public void Listar(){

        butListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res= mydb.getListar();

                if(res.getCount()==0){
                    // mensaje
                    menssage("Error","No hay ningun dato");
                    System.out.println("----------------------------");
                    return;
                }

                StringBuffer buffer=new StringBuffer();

                while (res.moveToNext()){
                    System.out.println("*******");
                    buffer.append("ID :"+res.getString(0)+"\n");
                    buffer.append("NAME :"+res.getString(1)+"\n");
                    buffer.append("SURNAME :"+res.getString(2)+"\n");
                    buffer.append("MARKS :"+res.getString(3)+"\n");
                    buffer.append("SEXO :"+res.getString(4)+"\n\n");
                    // System.out.println(buffer.toString());
                }

                menssage("Info",buffer.toString());


            }
        });
    }

    public void menssage(String title,String menssage){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(menssage);
        builder.show();
    }


    public void UpdateBase(){




        butUp.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                String sexo = null;
                if(Rmas.isChecked()){

                    sexo="masculino";
                }if(Rfen.isChecked()){
                    sexo=Rfen.getText().toString();
                }

                boolean isUpdate=
                        mydb.updateData(editTextId.getText().toString(),editName.getText().toString()
                                ,editSurname.getText().toString(),editMarks.getText().toString(),sexo);
                if(isUpdate==true){

                    Toast.makeText(Main2Activity.this,"Actualizado",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Main2Activity.this,"No se actualizo",Toast.LENGTH_SHORT).show();
                }

                editName.setText("");
                editSurname.setText("");
                editMarks.setText("");
                editTextId.setText("");
            }
        });
    }

    public void Delete(){
        butDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleteRow= mydb.delete(editTextId.getText().toString());

                if(deleteRow>0){

                    Toast.makeText(Main2Activity.this,"Borrado",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Main2Activity.this,"No se Borro",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void buscar(){

        butBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res= mydb.getListar();

                if(res.getCount()==0){
                    // mensaje
                    menssage("Error","No hay ningun dato");
                    System.out.println("----------------------------");
                    return;
                }


                StringBuffer buffer=new StringBuffer();

                while (res.moveToNext()){
                    if(res.getString(0).equals(editTextId.getText().toString())){
                        buffer.append("ID :"+res.getString(0)+"\n");
                        buffer.append("NAME :"+res.getString(1)+"\n");
                        buffer.append("SURNAME :"+res.getString(2)+"\n");
                        buffer.append("MARKS :"+res.getString(3)+"\n");
                        buffer.append("SEXO :"+res.getString(4)+"\n\n");
                        // System.out.println(buffer.toString());

                    }

                }

                menssage("Info",buffer.toString());

            }
        });



    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==R.id.item_info){
            StringBuffer buffer=new StringBuffer();
            buffer.append("Creado por Miguel López"+"\n");
            buffer.append("Proyecto gestion de alumnos"+"\n");
            buffer.append("Programación de dispositivos moviles"+"\n");
            buffer.append("Curso 2019/2020"+"\n");
            menssage("Info",buffer.toString());
        }
        if(id==R.id.item_ayu){
            StringBuffer buffer=new StringBuffer();
            buffer.append("Si necesita ayuda contacte con :"+"\n");
            buffer.append("migboi@alu.iesserpis.org"+"\n");
            buffer.append(""+"\n");
            buffer.append("Curso 2019/2020"+"\n");
            buffer.append("Profesora Angeles"+"\n");
            menssage("Info",buffer.toString());
        }
        if(id==R.id.item_copy){
            startActivity(new Intent(this,Main2ActivityCopy.class));
        }

        return super.onOptionsItemSelected(item);

    }

}


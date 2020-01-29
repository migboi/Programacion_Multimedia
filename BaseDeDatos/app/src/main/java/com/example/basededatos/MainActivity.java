package com.example.basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_codigo,et_descripcion,et_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_codigo=(EditText)findViewById(R.id.txt_codigo);
        et_descripcion=(EditText)findViewById(R.id.text_descripcion);
        et_precio=(EditText)findViewById(R.id.txt_precio);

    }


    //metodo para dar de alta

    public void Registar(View view){

        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper
                (this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();

        String codigo=et_codigo.getText().toString();
        String descripcion=et_descripcion.getText().toString();
        String precio=et_precio.getText().toString();

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){
            ContentValues registro=new ContentValues();
            registro.put("codigo",codigo);
            registro.put("descripcion",descripcion);
            registro.put("precio",precio);

            BaseDeDatos.insert("articulos",null,registro);
            BaseDeDatos.close();

            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            Toast.makeText(this,"Campos insertados",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this,"Debes rellenar todos los campos",Toast.LENGTH_SHORT).show();
            BaseDeDatos.close();
        }



    }
    //metodo para consultar un articulo
    public  void Buscar(View view){



        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper
                (this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();

        String codigo=et_codigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila=BaseDeDatos.rawQuery
                    ("select descripcion,precio from articulos where codigo =' "+codigo+" ' ",null);

            if(fila.moveToFirst()){

                et_descripcion.setText(fila.getString(0));
                et_precio.setText(fila.getString(1));


                BaseDeDatos.close();

            }else{
                Toast.makeText(this,"El articulo no exite",Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }

        }else{
            Toast.makeText(this,"Debes introducir el codigo",Toast.LENGTH_SHORT).show();
        }



    }

    //Eliminar un articulo

    public void Eliminar(View view){
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper
                (this,"administracion",null,1);

        SQLiteDatabase BaseDeDatos =admin.getWritableDatabase();
        String codigo=et_codigo.getText().toString();

        if(!codigo.isEmpty()){

            int cantidad=BaseDeDatos.delete("articulos","codigo="+codigo,null);

            BaseDeDatos.close();

            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            if(cantidad==1){
                Toast.makeText(this,"Articulo eliminado correctamente",Toast.LENGTH_SHORT).show();
            }else{

                Toast.makeText(this,"Articulo NO SE eliminado correctamente",Toast.LENGTH_SHORT).show();
            }





        }else{
            Toast.makeText(this,"Debes introducir el codigo",Toast.LENGTH_SHORT).show();

        }



    }

    //metodo para modifcar un producto
    public void Modificar(View view){

        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper
                (this,"administracion",null,1);

        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();

        String codigo=et_codigo.getText().toString();
        String descripcion=et_descripcion.getText().toString();
        String precio=et_precio.getText().toString();

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){

            ContentValues registro=new ContentValues();
            registro.put("codigo",codigo);
            registro.put("descripcion",descripcion);
            registro.put("precio",precio);

            int cantidad=BaseDeDatos.update("articulos",registro,"codigo="+codigo,null);
            BaseDeDatos.close();

            if(cantidad==1){
                Toast.makeText(this,"Se han  modificado los datos",Toast.LENGTH_SHORT).show();
            }else{

            }Toast.makeText(this,"No se ha modificado los datos",Toast.LENGTH_SHORT).show();


        }else{
            Toast.makeText(this,"No se ha modificado los datos",Toast.LENGTH_SHORT).show();
        }


    }







}
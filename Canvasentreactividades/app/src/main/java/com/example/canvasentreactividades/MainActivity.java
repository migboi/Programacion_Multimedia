package com.example.canvasentreactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNombre=(EditText)findViewById(R.id.editText);



    }


    public void onclic(View view){
        Intent intent=new Intent(this,Main2Activity.class);
        intent.putExtra("dato",edNombre.getText().toString());
        startActivity(intent);


    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public  boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==R.id.I1){
            startActivity(new Intent(this,Main3Activity.class));
        }if(id==R.id.I2){
            Toast.makeText(this,"Opcion 2",Toast.LENGTH_SHORT).show();
        }if(id==R.id.i3){
            Toast.makeText(this,"Opcion 3",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.listatareas;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

public class ItemActivity extends Activity {
    //referencias a elementos de pantalla
    TextView mItem = null;
    TextView mPlace = null;
    TextView mDescription  = null;
    TextView mImportance  = null;
    //identificador de entrada
    Integer  mRowId = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_item);
        //botón de salvar
        Button saveBtn = (Button) findViewById(R.id.add);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setResult(RESULT_OK);
                saveData();
                finish();
            }
        });
// obtener referencias
        mItem = (TextView) findViewById(R.id.item);
        mPlace = (TextView) findViewById(R.id.place);
        mDescription  = (TextView) findViewById(R.id.description);
        mImportance  = (TextView) findViewById(R.id.importance);
    }
    protected void saveData() {
//obtener datos
        String itemText = mItem.getText().toString();
        String placeText = mPlace.getText().toString();
        String descriptionText = mDescription.getText().toString();
        String importanceText = mImportance.getText().toString();
        //insertar
        try{
            MainActivity.mDbHelper.open();
            MainActivity.mDbHelper.insertItem(itemText, placeText, descriptionText,             Integer.parseInt(importanceText));
            MainActivity.mDbHelper.close();
        } catch (Exception e) {
            e.printStackTrace();
            showMessage(R.string.dataError);
        }
    }
    private void showMessage(int message){
        Context context = getApplicationContext();
        CharSequence text = getResources().getString(message);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}

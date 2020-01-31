package com.example.listatarea2;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends Activity {
    //referencias a elementos de pantalla
    TextView mItem = null;
    TextView mPlace = null;
    TextView mDescription = null;
    TextView mImportance = null;
    //identificador de entrada
    Integer mRowId = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //obtención de extras, identificador y acción
        Bundle extras = getIntent().getExtras();
        mRowId = (savedInstanceState == null) ? null :
                (Integer) savedInstanceState.getSerializable(DataBaseHelper.SL_ID);
        if (mRowId == null) {
            mRowId = extras != null ? extras.getInt(DataBaseHelper.SL_ID): null;
        }
        // es solo para visualizar?
        if (extras != null && extras.getInt("action")== MainActivity.SHOW_ITEM) {
            setContentView(R.layout.detail_item);
        }
        else{
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
        }
        // obtener referencias
        mItem = (TextView) findViewById(R.id.item);
        mPlace = (TextView) findViewById(R.id.place);
        mDescription  = (TextView) findViewById(R.id.description);
        mImportance  = (TextView) findViewById(R.id.importance);
        //identificador visible o no
        TableRow tr = (TableRow) findViewById(R.id.idRow);
        if (mRowId!=null){
            tr.setVisibility(View.VISIBLE);
            populateFieldsFromDB();
        }
        else{
            tr.setVisibility(View.GONE);
        }
    }




    private void showMessage(int message) {
        Context context = getApplicationContext();
        CharSequence text = getResources().getString(message);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void populateFieldsFromDB() {
        try {
            MainActivity.mDbHelper.open();
            Cursor c = MainActivity.mDbHelper.getItem(mRowId.intValue());
            if (c.moveToFirst()) {
                //diferentes maneras de obtener los datos del cursor
                //Mediante nombre de columna y lanza excepción si no existe
                mItem.setText(c.getString(c.getColumnIndexOrThrow(DataBaseHelper.SL_ITEM)));
                //Mediante nombre de columna y devuelve -1 si no existe
                mPlace.setText(c.getString(c.getColumnIndex(DataBaseHelper.SL_PLACE)));
                //Mediante posición del campo en el cursor
                mDescription.setText(c.getString(2));
                mImportance.setText(Integer.toString(c.getInt(3)));
                TextView id = (TextView) findViewById(R.id.identificator);
                id.setText(Integer.toString(c.getInt(4)));
            }
            c.close();
            MainActivity.mDbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage(R.string.dataError);
        }
    }


    protected void saveData() {
        //obtener datos
        String itemText = mItem.getText().toString();
        String placeText = mPlace.getText().toString();
        String descriptionText = mDescription.getText().toString();
        String importanceText = mImportance.getText().toString();
        try {
            MainActivity.mDbHelper.open();
            if (mRowId == null){
                //insertar
                MainActivity.mDbHelper.insertItem(itemText, placeText, descriptionText, 		Integer.parseInt(importanceText));
            }
            else{
                //actualizar
                TextView tv = (TextView)findViewById(R.id.identificator);
                String ident = tv.getText().toString();
                MainActivity.mDbHelper.updateItem(Integer.parseInt(ident),itemText, placeText, descriptionText, Integer.parseInt(importanceText));
            }
            MainActivity.mDbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage(R.string.dataError);
        }
    }

}

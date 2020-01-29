package com.example.listatareas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {
    // acciones
    public static final int NEW_ITEM = 1;
    public static final int EDIT_ITEM = 2;
    public static final int SHOW_ITEM = 3;

    private int mLastRowSelected = 0; //elemento seleccionado
    public static DataBaseHelper mDbHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // abrir la base de datos
        mDbHelper = new DataBaseHelper(this);
        try {
            fillData();
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

    private void fillData() {
        // se abre la base de datos y se obtienen los elementos
        mDbHelper.open();
        Cursor itemCursor = mDbHelper.getItems();
        ListEntry item = null;
        ArrayList<ListEntry> resultList = new ArrayList<ListEntry>();
        // se procesa el resultado
        while (itemCursor.moveToNext()) {
            int id = itemCursor.getInt(itemCursor.getColumnIndex(DataBaseHelper.SL_ID));
            String task = itemCursor.getString(itemCursor.getColumnIndex(DataBaseHelper.SL_ITEM));
            String place = itemCursor.getString(itemCursor.getColumnIndex(DataBaseHelper.SL_PLACE));
            int importance = itemCursor.getInt(itemCursor.getColumnIndex(DataBaseHelper.SL_IMPORTANCE));
            item = new ListEntry();
            item.id = id;
            item.task = task;
            item.place = place;
            item.importance= importance;
            resultList.add(item);
        }
        //cerramos la base de datos
        itemCursor.close();
        mDbHelper.close();
        TaskAdapter items = new TaskAdapter(this, R.layout.row_list, resultList, getLayoutInflater());
        //asignar adaptador a la lista
        setListAdapter(items);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_item:
                Intent intent = new Intent (this,ItemActivity.class);
                startActivityForResult(intent, NEW_ITEM);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    private class TaskAdapter extends ArrayAdapter<ListEntry> {
        private LayoutInflater mInflater;
        private List<ListEntry> mObjects;
        private TaskAdapter(Context context, int resource, List<ListEntry> objects, LayoutInflater mInflater) {
            super(context, resource, objects);
            this.mInflater = mInflater;
            this.mObjects = objects;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ListEntry listEntry = mObjects.get(position);
            // obtención de la vista de la línea de la tabla
            View row = mInflater.inflate(R.layout.row_list, null);
            //rellenamos datos
            TextView place = (TextView) row.findViewById(R.id.row_place);
            TextView item = (TextView) row.findViewById(R.id.row_item);
            place.setText(listEntry.place);
            item.setText(listEntry.task);
            // dependiendo de la importancia, se muestran distintos iconos
            ImageView icon = (ImageView) row.findViewById(R.id.row_importance);
            icon.setTag(new Integer(listEntry.id));
            switch (listEntry.importance) {
                case 1:
                    icon.setImageResource(R.drawable.ic_green);
                    break;
                case 2:
                    icon.setImageResource(R.drawable.ic_yellow);
                    break;
                default:
                    icon.setImageResource(R.drawable.ic_red);
                    break;
            }
            return row;
        }
    }

    private class ListEntry {
        int id;
        String task;
        String place;
        int importance;
    }
}

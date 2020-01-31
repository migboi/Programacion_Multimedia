package com.example.listatarea2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ListActivity{
    //acciones
    public static final int NEW_ITEM = 1;
    public static final int EDIT_ITEM = 2;
    public static final int SHOW_ITEM = 3;

    //elemento seleccionado
    private int mLastRowSelected = 0;
    public static DataBaseHelper mDbHelper = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // abrir la base de datos
        mDbHelper = new DataBaseHelper(this);
        try {
            fillData();
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage(R.string.dataError);
        }
        registerForContextMenu(getListView());
    }

    private void showMessage(int message){
        Context context = getApplicationContext();
        CharSequence text = getResources().getString(message);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    protected void deleteEntry() {
        try{
            mDbHelper.open();
            mDbHelper.delete(((ListEntry)getListAdapter().getItem(mLastRowSelected)).id);
            mDbHelper.close();
            fillData();
        }catch (SQLException e){
            e.printStackTrace();
            showMessage(R.string.dataError);
        }
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
        //se genera el adaptador
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
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context, menu);
    }

    @Override
     public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo delW = (AdapterView.AdapterContextMenuInfo) item
                .getMenuInfo();
//salvar identificador del elemento pulsado
        mLastRowSelected = delW.position;
        // comprobar el elemento seleccionado
        switch (item.getItemId()) {
            case R.id.delete_item:
                //preguntar si está seguro de borrarlo
                new AlertDialog.Builder(this).setTitle(
                        this.getString(R.string.alrtDelete)).setMessage(
                        R.string.alrtDeleteEntry).setPositiveButton(
                        android.R.string.ok, new AlertDialog.OnClickListener() {
                            public void onClick(DialogInterface dlg, int i) {
                                deleteEntry();
                            }									}).setNegativeButton(android.R.string.cancel, null).show();
                return true;
            case R.id.edit_item:
                //nueva actividad con el identificador como parámetro
                Intent i = new Intent(this, ItemActivity.class);
                i.putExtra(DataBaseHelper.SL_ID, ((ListEntry)getListAdapter().getItem(mLastRowSelected)).id);
                startActivityForResult(i, EDIT_ITEM);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
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

    @Override
     protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, ItemActivity.class);
        int rowId = (Integer)v.findViewById(R.id.row_importance).getTag();
        i.putExtra(DataBaseHelper.SL_ID, rowId);
        i.putExtra("action", SHOW_ITEM);
        startActivityForResult(i, SHOW_ITEM);
    }


    @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EDIT_ITEM || requestCode == NEW_ITEM){
            if (resultCode == Activity.RESULT_OK){
                try {
                    fillData();
                } catch (SQLException e) {
                    e.printStackTrace();
                    showMessage(R.string.dataError);
                }
            }
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
            icon.setTag(listEntry.id);
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

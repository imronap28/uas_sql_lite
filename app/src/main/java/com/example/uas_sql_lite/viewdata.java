package com.example.uas_sql_lite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.ArrayList;
import android.app.ListActivity;
//import android.util.Log;
import android.widget.ArrayAdapter;

public class viewdata extends ListActivity {
    //inisialisasi kontroller
    private DBDataSource dataSource;

    //inisialisasi arraylist
    private ArrayList<barang> values;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdata);

        dataSource = new DBDataSource(this);
        // buka kontroller
        dataSource.open();

        // ambil semua data barang
        values = dataSource.getAllBarang();


        // masukkan data barang ke array adapter
        ArrayAdapter<barang> adapter = new ArrayAdapter<barang>(this, android.R.layout.simple_list_item_2, values);

        // set adapter pada list
        setListAdapter(adapter);
    }
}
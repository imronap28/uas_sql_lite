package com.example.uas_sql_lite;
import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
public class DBDataSource {
    //inisialiasi SQLite Database
    private SQLiteDatabase database;


    private DBHelper dbHelper;
    private String[] allColumns = { DBHelper.COLUMN_ID,
            DBHelper.COLUMN_NAME, DBHelper.COLUMN_MERK,DBHelper.COLUMN_HARGA};

    public DBDataSource(Context context)
    {
        dbHelper = new DBHelper(context);
    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }
    public barang createBarang(String nama, String merk, String harga) {

        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_NAME, nama);
        values.put(DBHelper.COLUMN_MERK, merk);
        values.put(DBHelper.COLUMN_HARGA, harga);
        long insertId = database.insert(DBHelper.TABLE_NAME, null,
                values);
        Cursor cursor = database.query(DBHelper.TABLE_NAME,
                allColumns, DBHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);

        cursor.moveToFirst();


        barang newBarang = cursorToBarang(cursor);

        cursor.close();
        return newBarang;
    }
    private barang cursorToBarang(Cursor cursor)
    {
        barang barang = new barang();
        Log.v("info", "The getLONG "+cursor.getLong(0));
        Log.v("info", "The setLatLng "+cursor.getString(1)+","+cursor.getString(2));
        barang.setId(cursor.getLong(0));
        barang.setNama_barang(cursor.getString(1));
        barang.setMerk_barang(cursor.getString(2));
        barang.setHarga_barang(cursor.getString(3));

        return barang;
    }
    public ArrayList<barang> getAllBarang() {
        ArrayList<barang> daftarBarang = new ArrayList<barang>();

        Cursor cursor = database.query(DBHelper.TABLE_NAME,
                allColumns, null, null, null, null, null);
        while (!cursor.isAfterLast()) {
            barang barang = cursorToBarang(cursor);
            daftarBarang.add(barang);
            cursor.moveToNext();

            cursor.close();
            return daftarBarang;
        }
        return daftarBarang;
    }
}





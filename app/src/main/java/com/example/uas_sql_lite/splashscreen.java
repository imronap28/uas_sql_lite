package com.example.uas_sql_lite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.content.Intent;


public class splashscreen extends AppCompatActivity {
    private int waktu_loading=10000;
    //4000=4detik
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent login = new Intent(splashscreen.this, login.class);
                startActivity(login);
                finish();
            }
        }, waktu_loading);
    }
}



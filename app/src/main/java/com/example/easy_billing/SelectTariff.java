package com.example.easy_billing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SelectTariff extends AppCompatActivity {



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();
        if (item_id==R.id.Weather_id){
         Intent i = new Intent(SelectTariff.this,MainActivity.class);
         startActivity(i);
         finish();

        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_tariff);


        ImageButton domestic = findViewById(R.id.Domestic_id);
        ImageButton religious = findViewById(R.id.Relegious_id);
        ImageButton retail = findViewById(R.id.Retail_id);


        Toolbar toolbar = findViewById(R.id.Toolbar_id);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });




        domestic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectTariff.this,Domestic.class);
                startActivity(intent);
            }
        });

        religious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectTariff.this,Religious.class);
                startActivity(intent);
            }
        });

        retail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectTariff.this,Retail.class);
                startActivity(intent);
            }
        });



    }
}
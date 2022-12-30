package com.example.easy_billing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SelectTariff extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_tariff);

        getSupportActionBar().hide();
        ImageButton domestic = findViewById(R.id.Domestic_id);
        ImageButton religious = findViewById(R.id.Relegious_id);
        ImageButton retail = findViewById(R.id.Retail_id);
        ImageView back = findViewById(R.id.left_icon);


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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectTariff.this,Login.class);
                startActivity(intent);
            }
        });

    }
}
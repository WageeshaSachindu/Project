package com.example.easy_billing;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

public class Domestic extends AppCompatActivity {

    private EditText etSelectDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domestic);

        getSupportActionBar().hide();

            etSelectDate = findViewById(R.id.etSelectDate);

            final Calendar calendar = Calendar.getInstance();
            final int year = calendar.get(Calendar.YEAR);
            final int month = calendar.get(Calendar.MONTH);
            final int day = calendar.get(Calendar.DAY_OF_MONTH);

            etSelectDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DatePickerDialog dialog = new DatePickerDialog(Domestic.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            month = month+1;
                            String date = dayOfMonth+"/"+month+"/"+year;
                            etSelectDate.setText(date);

                        }
                    },year, month,day);
                    dialog.show();

                }
            });

        Button bill3 = findViewById(R.id.btnBillDom_id);
        ImageView back = findViewById(R.id.left_icon);

        bill3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Domestic.this,BillGenerate.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Domestic.this,SelectTariff.class);
                startActivity(intent);
            }
        });



        }
}
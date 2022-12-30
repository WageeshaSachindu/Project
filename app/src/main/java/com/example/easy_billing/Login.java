package com.example.easy_billing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

                TextView username =(TextView) findViewById(R.id.username);
                TextView password =(TextView) findViewById(R.id.password);

                MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

                //admin and admin

                loginbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(username.getText().toString().equals("ebill") && password.getText().toString().equals("12345")){
                            //correct

                            Intent i = new Intent(Login.this,SelectTariff.class);
                            startActivity(i);
                        }else
                            //incorrect
                            Toast.makeText(Login.this,"USERNAME OR PASSWORD WRONG",Toast.LENGTH_SHORT).show();
                    }
                });


            }
        }



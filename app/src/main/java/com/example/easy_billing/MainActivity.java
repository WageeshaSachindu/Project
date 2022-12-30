package com.example.easy_billing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText city,country;
    TextView result;

    private final String url = "https://api.openweathermap.org/data/2.5/weather";
    private final String appid = "b89f3fc4f9076fc891813373f8d1eac9";
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        city = findViewById(R.id.City_id);
        country = findViewById(R.id.Country_id);
        result = findViewById(R.id.Result);
        Button button = findViewById(R.id.btnExit);


        getSupportActionBar().hide();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SelectTariff.class);
                startActivity(i);
            }
        });


    }

    public void getweatherdetails(View view) {

        String tempurl ="";
        String eCity = city.getText().toString().trim();
        String eCountry = country.getText().toString().trim();
        if (city.equals("")){
            result.setText("Empty");

        }else {
            if (country.equals("")){
                tempurl = url + "?q=" + city +","+country+"&appid="+appid;

            }else {
                tempurl = url + "?q=" + city +"&appid="+appid;
            }
            StringRequest stringRequest = new  StringRequest(Request.Method.POST, tempurl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //Log.d("response",response);
                    String output = "";
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        JSONArray jsonArray = jsonResponse.getJSONArray("Weather");
                        JSONObject jsonObjectWeather = jsonArray.getJSONObject(0);
                        String description = jsonObjectWeather.getString("description");
                        JSONObject jsonObjectMain = jsonResponse.getJSONObject("main");
                        double temp = jsonObjectMain.getDouble("temp")-273.15;
                        double feelslike = jsonObjectMain.getDouble("feels like")-273.15;
                        JSONObject jsonObjectClouds = jsonResponse.getJSONObject("clouds");
                        String clouds = jsonObjectClouds.getString("all");
                        String cityname =jsonResponse.getString("name");

                        output += "Current weather of " + cityname + "\n Temp : "+df.format(temp)+"Celcious"
                                + "\n Feels like : "+df.format(feelslike)+"Celcious"
                                + "\n Cloudiness : "+df.format(clouds)
                        + "\n Description : "+df.format(description);

                        result.setText(output);
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
                }, new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){

                    Toast.makeText(getApplicationContext(),error.toString().trim(),Toast.LENGTH_SHORT).show();
                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }
}
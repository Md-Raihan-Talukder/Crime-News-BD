package com.example.sultanahmed.crimenewsbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.*;

public class PoliceStationAdd extends AppCompatActivity {

    private EditText station_name2,number_about,email_value;

    private String station_name,number,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_station_add);
        getSupportActionBar().setTitle("ADD POLICE");

        number_about = (EditText) findViewById(R.id.number);
        station_name2 = (EditText) findViewById(R.id.station_name);
        email_value = (EditText) findViewById(R.id.email);

    }
    public void insert(View view){

        if(number_about.getText().toString().equals("") &&
                station_name2.getText().toString().equals("") &&
                email_value.getText().toString().equals("")){
            //add toast here
            Toast.makeText(PoliceStationAdd.this, "please fill all the fields...", Toast.LENGTH_SHORT).show();
        }
        else {

            station_name = station_name2.getText().toString();
            number = number_about.getText().toString();
            email = email_value.getText().toString();

            RequestQueue requestQueue = Volley.newRequestQueue(PoliceStationAdd.this);

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.ploiceListAdd,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(PoliceStationAdd.this, response, Toast.LENGTH_SHORT).show();

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(PoliceStationAdd.this, error.toString(), Toast.LENGTH_LONG).show();

                }
            }) {
                @Override
                protected java.util.Map<String, String> getParams() throws AuthFailureError {
                    java.util.Map<String, String> params = new HashMap<String, String>();

                    params.put("send_station_name", station_name);
                    //station_name ke send_station_name name php te pathassi n post mehod dara php ta receive korbe
                    params.put("send_number", number);
                    params.put("send_email", email);

                    return params;
                }

            };

            requestQueue.add(stringRequest);

        }

        Intent intent = new Intent(PoliceStationAdd.this,PoliceStationList.class);
        startActivity(intent);

    }
}

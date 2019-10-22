package com.example.sultanahmed.crimenewsbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.*;

public class Details extends AppCompatActivity {

    private TextView title_name,news_about,time_value,location_area;

    private String title,news,time,location;

    private Button delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        title_name = (TextView) findViewById(R.id.title);
        news_about = (TextView) findViewById(R.id.news);
        time_value = (TextView) findViewById(R.id.time);
        location_area = (TextView) findViewById(R.id.location);

        Intent intent = getIntent();
        //getId=intent.getExtras().getString("Id_no");

        title = intent.getExtras().getString("title");
        news = intent.getExtras().getString("news");
        time = intent.getExtras().getString("time");
        location = intent.getExtras().getString("location");

        title_name.setText(title);
        news_about.setText(news);
        time_value.setText(time);
        location_area.setText(location);

        /*delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // deleting product in background thread
                RequestQueue requestQueue = Volley.newRequestQueue(Details.this);

                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.Delete_Food,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                Toast.makeText(Details.this, response, Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(Details.this, error.toString(), Toast.LENGTH_SHORT).show();

                    }
                }) {
                    @Override
                    protected java.util.Map<String, String> getParams() throws AuthFailureError {
                        java.util.Map<String, String> params = new HashMap<String, String>();

                        //StudentUnit studentUnit = new StudentUnit();

                        params.put("title", title);
                        return params;
                    }

                };
                requestQueue.add(stringRequest);

                //Intent intent = new Intent(NewsDetails.this,Admin.class);
                //startActivity(intent);
            }
        });*/
    }
}

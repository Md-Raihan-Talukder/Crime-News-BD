package com.example.sultanahmed.crimenewsbd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
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

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Barisal extends AppCompatActivity {
    private TextView murder,rape,corruption,illegal,robbery;
    CardView cardView;
    JSONArray jsonArray=null;
    private String name,Id_no,reg_no;
    String setCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barisal);
        getSupportActionBar().setTitle("BARISAL REVIEW");
        murder=(TextView ) findViewById(R.id.murder);
        rape=(TextView ) findViewById(R.id.rape);
        corruption=(TextView)findViewById(R.id.corruption);
        illegal=(TextView)findViewById(R.id.domination);
        robbery=(TextView)findViewById(R.id.robbery);
        barisalMurder();
        barisalRape();
        barisalCorruption();
        barisalRobbery();
        barisalIllegal();
    }

    public void barisalMurder(){
        RequestQueue requestQueue = Volley.newRequestQueue(Barisal.this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.bmurder,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject=null;

                        try {
                            jsonObject= new JSONObject(response);
                            jsonArray=jsonObject.getJSONArray("result");
                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject j=jsonArray.getJSONObject(i);
                                murder.setText(j.getString("murder"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        ////Toast.makeText(Barisal.this, response, Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //Toast.makeText(Barisal.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(stringRequest);
    }

    public void barisalRape(){
        RequestQueue requestQueue = Volley.newRequestQueue(Barisal.this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.brape,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject=null;

                        try {
                            jsonObject= new JSONObject(response);
                            jsonArray=jsonObject.getJSONArray("result");
                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject j=jsonArray.getJSONObject(i);
                                rape.setText(j.getString("rape"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //Toast.makeText(Barisal.this, response, Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //Toast.makeText(Barisal.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(stringRequest);
    }

    public void barisalCorruption(){
        RequestQueue requestQueue = Volley.newRequestQueue(Barisal.this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.bcorruption,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject=null;

                        try {
                            jsonObject= new JSONObject(response);
                            jsonArray=jsonObject.getJSONArray("result");
                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject j=jsonArray.getJSONObject(i);
                                corruption.setText(j.getString("corruption"));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //Toast.makeText(Barisal.this, response, Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //Toast.makeText(Barisal.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(stringRequest);
    }

    public void barisalIllegal(){
        RequestQueue requestQueue = Volley.newRequestQueue(Barisal.this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.billegal,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject=null;

                        try {
                            jsonObject= new JSONObject(response);
                            jsonArray=jsonObject.getJSONArray("result");
                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject j=jsonArray.getJSONObject(i);
                                illegal.setText(j.getString("illegal"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //Toast.makeText(Barisal.this, response, Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //Toast.makeText(Barisal.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(stringRequest);
    }

    public void barisalRobbery(){
        RequestQueue requestQueue = Volley.newRequestQueue(Barisal.this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.brobbery,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject=null;

                        try {
                            jsonObject= new JSONObject(response);
                            jsonArray=jsonObject.getJSONArray("result");
                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject j=jsonArray.getJSONObject(i);
                                robbery.setText(j.getString("robbery"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //Toast.makeText(Barisal.this, response, Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //Toast.makeText(Barisal.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(stringRequest);
    }

}


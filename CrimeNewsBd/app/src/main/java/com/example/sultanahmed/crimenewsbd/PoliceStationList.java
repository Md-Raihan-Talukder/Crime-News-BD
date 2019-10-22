package com.example.sultanahmed.crimenewsbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
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

import java.util.*;

public class PoliceStationList extends AppCompatActivity {

    private ListView listView;
    private NewsAdapter newsAdapter;
    private ArrayAdapter<String> divAdapter,disAdapter;
    private List<NewsUnit> newsUnitList = new ArrayList<NewsUnit>();
    private AutoCompleteTextView dis;
    public String search,gotValue;

    public static String[] disList = {"Barguna","Barisal","Bhola","Jhalokati","Patuakhali",
            "Pirojpur","Bandarban","Brahmanbaria","Chandpur", "Chittagong","Comilla","Cox's Bazar",
            "Feni","Khagrachhari","Lakshmipur","Noakhali", "Rangamati","Dhaka","Faridpur","Gazipur",
            "Gopalganj","Kishoreganj","Madaripur", "Manikganj","Munshiganj",  "Narayanganj",
            "Narsingdi","Rajbari","Shariatpur","Tangail","Khulna","Bagerhat","Chuadanga","Jessore",
            "Jhenaidah","Khulna","Kushtia","Magura","Meherpur","Narail","Satkhira","Mymensingh",
            "Jamalpur","Mymensingh","Netrakona","Sherpur","Rajshahi","Bogra","Chapainawabganj",
            "Joypurhat","Naogaon","Natore","Pabna","Rajshahi","Sirajganj",
            "Rangpur","Dinajpur", "Gaibandha","Kurigram","Lalmonirhat","Nilphamari","Panchagarh",
            "Rangpur", "Thakurgaon","Sylhet","Habiganj","Moulvibazar","Sunamganj","Sylhet"};

    ArrayList<String> list = new ArrayList<String>();



    private JSONArray jsonArray = null;
    public static final String JSON_ARRAY = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_station_list);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        getSupportActionBar().setTitle("Police Station List");

        listView = (ListView) findViewById(R.id.stationList);
        dis=(AutoCompleteTextView)findViewById(R.id.dis);
        //div.setSelection(div.getText().length()/2);//cursor position


        disAdapter=new ArrayAdapter<String>(PoliceStationList.this,android.R.layout.simple_expandable_list_item_1,disList);
        //spinner e adapter ta set korlam
        dis.setAdapter(disAdapter);
        click();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.ploiceListShow,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //Toast.makeText(ShowAllNews.this, response, Toast.LENGTH_SHORT).show();
                        JSONObject jsonObject = null;
                        newsUnitList.clear();

                        try {

                            jsonObject = new JSONObject(response);
                            jsonArray = jsonObject.getJSONArray(JSON_ARRAY);

                            if (jsonArray.length() == 0) {
                                Toast.makeText(PoliceStationList.this, "No Data Recorded", Toast.LENGTH_SHORT).show();
                            } else {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    NewsUnit newsUnit = new NewsUnit();

                                    newsUnit.setTitle(object.getString("json_station_name"));
                                    newsUnit.setNews(object.getString("json_number"));
                                    newsUnit.setTime(object.getString("json_email"));
                                    //json_station_name,json_number,json_email json variable guloke
                                    //json object dara get kore set kora holo


                                    newsUnitList.add(newsUnit);
                                    //newsUnitList ekta arraylist er object
                                }
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        newsAdapter = new NewsAdapter(PoliceStationList.this, newsUnitList);
                        listView.setAdapter(newsAdapter);
                        //newsAdapter NewsAdapter classer object ja array list ke listView e add kore

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(PoliceStationList.this, "Connection Error \n check your " +
                        "internet connection "+error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(PoliceStationList.this);
        requestQueue.add(stringRequest);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(PoliceStationList.this,PoliceStationDetail.class);

                NewsUnit me  = newsUnitList.get(position);

                intent.putExtra("station_name",me.getTitle());
                intent.putExtra("number",me.getNews());
                intent.putExtra("email",me.getTime());

                startActivity(intent);

            }
        });
    }




    //search

    public void click(){
        for (int i = 0; i < disList.length; ++i) {
            list.add(disList[i]);
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        dis.setAdapter(adapter);

        dis.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                search=dis.getText().toString();
                /*Toast.makeText(PoliceStationList.this,
                        adapter.getItem(position).toString(),
                        Toast.LENGTH_SHORT).show();*/




                //***********************************************************************************************
                RequestQueue requestQueue = Volley.newRequestQueue(PoliceStationList.this);

                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.src,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                JSONObject jsonObject=null;

                                try {
                                    jsonObject= new JSONObject(response);
                                    jsonArray=jsonObject.getJSONArray("result");
                                    //php er json_encode(array("result"=>$result)) er "result" holo json
                                    //array name
                                    for(int i=0;i<jsonArray.length();i++)
                                    {
                                        Intent intent = new Intent(PoliceStationList.this,PoliceStationDetail.class);
                                        JSONObject j=jsonArray.getJSONObject(i);
                                        intent.putExtra("station_name",j.getString("station_name"));
                                        intent.putExtra("number",j.getString("number"));
                                        intent.putExtra("email",j.getString("email"));
                                        startActivity(intent);
                                       // dis.setText(j.getString("email"));
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                Toast.makeText(PoliceStationList.this, response, Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(PoliceStationList.this, error.toString(), Toast.LENGTH_SHORT).show();

                    }
                }) {
                    @Override
                    protected java.util.Map<String, String> getParams() {
                        java.util.Map<String, String> params = new HashMap<String, String>();
                        params.put("station_name", search);
                        return params;
                    }

                };
                requestQueue.add(stringRequest);


               // Toast.makeText(PoliceStationList.this, "success ", Toast.LENGTH_SHORT).show();

                //*******************************************************************************************




            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.police_list_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void add(MenuItem item){
        Intent intent=new Intent(PoliceStationList.this,LoginStation.class);
        startActivity(intent);
    }

}

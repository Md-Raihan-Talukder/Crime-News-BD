package com.example.sultanahmed.crimenewsbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.List;

public class PoliceStationShow extends AppCompatActivity {

    private ListView listView;
    private NewsAdapter newsAdapter;
    private List<NewsUnit> newsUnitList = new ArrayList<NewsUnit>();

    private JSONArray jsonArray = null;
    public static final String JSON_ARRAY = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_station_show);
        getSupportActionBar().setTitle("Police Station List");

        listView = (ListView) findViewById(R.id.stationList);

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
                                Toast.makeText(PoliceStationShow.this, "No Data Recorded", Toast.LENGTH_SHORT).show();
                            } else {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    NewsUnit newsUnit = new NewsUnit();

                                    newsUnit.setTitle(object.getString("station_name"));
                                    newsUnit.setNews(object.getString("number"));
                                    newsUnit.setTime(object.getString("email"));


                                    newsUnitList.add(newsUnit);
                                }
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        newsAdapter = new NewsAdapter(PoliceStationShow.this, newsUnitList);
                        listView.setAdapter(newsAdapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(PoliceStationShow.this, "vulval "+error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(PoliceStationShow.this);
        requestQueue.add(stringRequest);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(PoliceStationShow.this,PoliceStationDetail.class);

                NewsUnit me  = newsUnitList.get(position);

                intent.putExtra("station_name",me.getTitle());
                intent.putExtra("number",me.getNews());
                intent.putExtra("email",me.getTime());

                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.police_list_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void add(MenuItem item){
        Intent intent=new Intent(PoliceStationShow.this,LoginStation.class);
        startActivity(intent);
    }
}

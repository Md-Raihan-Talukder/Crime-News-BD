package com.example.sultanahmed.crimenewsbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class IllegalShow extends AppCompatActivity {
    private ListView listView;
    private NewsAdapter newsAdapter;
    private List<NewsUnit> newsUnitList = new ArrayList<NewsUnit>();


    private JSONArray jsonArray = null;

    public static final String JSON_ARRAY = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_news);
        getSupportActionBar().setTitle("ILLIGAL DOMINATION");

        listView = (ListView) findViewById(R.id.listView);


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.show_illegal,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //Toast.makeText(IllegalShow.this, response, Toast.LENGTH_SHORT).show();
                        JSONObject jsonObject = null;
                        newsUnitList.clear();

                        try {

                            jsonObject = new JSONObject(response);
                            jsonArray = jsonObject.getJSONArray(JSON_ARRAY);

                            if (jsonArray.length() == 0) {
                                Toast.makeText(IllegalShow.this, "No Data Recorded", Toast.LENGTH_SHORT).show();
                            } else {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    NewsUnit newsUnit = new NewsUnit();

                                    newsUnit.setTitle(object.getString("title"));
                                    newsUnit.setNews(object.getString("news"));
                                    newsUnit.setTime(object.getString("time"));
                                    newsUnit.setLocation(object.getString("location"));


                                    newsUnitList.add(newsUnit);
                                }
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        newsAdapter = new NewsAdapter(IllegalShow.this, newsUnitList);
                        listView.setAdapter(newsAdapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(IllegalShow.this, "vulval "+error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(IllegalShow.this);
        requestQueue.add(stringRequest);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(IllegalShow.this,Details.class);

                NewsUnit me  = newsUnitList.get(position);

                intent.putExtra("title",me.getTitle());
                intent.putExtra("news",me.getNews());
                intent.putExtra("time",me.getTime());
                intent.putExtra("location",me.getLocation());

                startActivity(intent);

            }
        });
    }
}

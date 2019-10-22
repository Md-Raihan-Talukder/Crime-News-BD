package com.example.sultanahmed.crimenewsbd;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.DateFormat;
import java.util.*;

public class AddNews extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private EditText title_name, news_about;
    private TextView time_value;
    TextView newsType;
    TextClock textClock;

    public String title, news, time;
    public static String[] days = {"select type","murder", "rape", "robbery", "corruption", "illegal","sports"};
    public static String[] division = {"select location","Dhaka","Khulna","Barisal","Shylet","Rajshahi","Rangpur","Chittagong","Mymensingh"};
    String type,location;
    Spinner spinner,myspinner;
    //Adapter class Listview n Spinner er View class return kore
    ArrayAdapter<String> adapter,adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);
        getSupportActionBar().setTitle("Post New News");

        news_about = (EditText) findViewById(R.id.news);
        title_name = (EditText) findViewById(R.id.title);
        time_value = (TextView) findViewById(R.id.time);
        spinner = (Spinner) findViewById(R.id.spinner);
        myspinner = (Spinner) findViewById(R.id.myspinner);

        textClock = (TextClock) findViewById(R.id.text2);
        textClock.setFormat12Hour("hh:mm:ss a");
        textClock.setFormat24Hour(null);

        ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        //adapter e day string dhorailam
        adapter=new ArrayAdapter<String>(AddNews.this,android.R.layout.simple_spinner_item,days);
        adapter1=new ArrayAdapter<String>(AddNews.this,android.R.layout.simple_spinner_item,division);
        //spinner e adapter ta set korlam
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                type=spinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        myspinner.setAdapter(adapter1);
        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                location=myspinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void insert(View view) {

        if (news_about.getText().toString().equals("") &&
                title_name.getText().toString().equals("") &&
                time_value.getText().toString().equals("")) {
            //add toast here
            Toast.makeText(AddNews.this, "please fill all the fields...", Toast.LENGTH_SHORT).show();
        } else {

            title = title_name.getText().toString();
            news = news_about.getText().toString();
            time = time_value.getText().toString();

            if (title.length() > 10 && news.length() > 20 && time.length() > 1) {

            RequestQueue requestQueue = Volley.newRequestQueue(AddNews.this);

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.add_news,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(AddNews.this, response, Toast.LENGTH_SHORT).show();

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(AddNews.this, error.toString(), Toast.LENGTH_SHORT).show();

                }
            }) {
                @Override
                protected java.util.Map<String, String> getParams() throws AuthFailureError {
                    java.util.Map<String, String> params = new HashMap<String, String>();

                    params.put("title", title);
                    params.put("news", news);
                    params.put("time", time);
                    params.put("type", type);
                    params.put("location", location);

                    return params;
                }

            };

            requestQueue.add(stringRequest);

                Intent intent=new Intent(AddNews.this,ShowAllNews.class);
                startActivity(intent);
                finish();

        }

        else{
                Toast.makeText(AddNews.this, "WARNING!\n" +
                        "title can not be less than 40 words \nand" +
                        "news can not be less than 60 words", Toast.LENGTH_LONG).show();
            }
    }
        /*Intent intent=new Intent(AddNews.this,ShowAllNews.class);
        startActivity(intent);
        finish();*/
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String date = DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime());
        String time = textClock.getText().toString();

        time_value.setText(date+", "+time);
    }
}

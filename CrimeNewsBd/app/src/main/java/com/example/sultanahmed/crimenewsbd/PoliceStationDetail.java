package com.example.sultanahmed.crimenewsbd;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
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

public class PoliceStationDetail extends AppCompatActivity {

    private TextView station,num,emails;

    private String station_name,number,email;

    private Button call;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_station_detail);
        getSupportActionBar().setTitle("About Police Station");

        station = (TextView) findViewById(R.id.station);
        num = (TextView) findViewById(R.id.num);
        emails = (TextView) findViewById(R.id.emails);

        call= (Button) findViewById(R.id.call);

        Intent intent = getIntent();
        //getId=intent.getExtras().getString("Id_no");

        station_name = intent.getExtras().getString("station_name");
        number = intent.getExtras().getString("number");
        email = intent.getExtras().getString("email");

        station.setText(station_name);
        num.setText(number);
        emails.setText(email);


    }
    public void call(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+number));
        startActivity(intent);
    }

    public void email(View view){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("email"));
        String[] s = {email};
        i.putExtra(Intent.EXTRA_EMAIL,s);
        i.putExtra(Intent.EXTRA_SUBJECT,"Type your Complain");
        i.putExtra(Intent.EXTRA_TEXT,"Type your Complain in Details");
        i.setType("message/rfc822");
        Intent chooser = Intent.createChooser(i,"Launch Email");
        startActivity(chooser);
    }

}

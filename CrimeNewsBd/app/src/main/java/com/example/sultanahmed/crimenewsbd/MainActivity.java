package com.example.sultanahmed.crimenewsbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void add(MenuItem item){
        Intent intent=new Intent(MainActivity.this,Login.class);
        startActivity(intent);
    }

    public void stat(View view){
        Intent intent=new Intent(MainActivity.this,Stat.class);
        startActivity(intent);
    }

    public void map(View view){
        Intent intent=new Intent(MainActivity.this,Map.class);
        startActivity(intent);
    }

    public void news(View view){
        Intent intent = new Intent(MainActivity.this,ShowAllNews.class);
        startActivity(intent);
    }
    public void police(View view){
        Intent intent = new Intent(MainActivity.this,PoliceStationList.class);
        startActivity(intent);
    }
    public void murder(View view){
        Intent intent = new Intent(MainActivity.this,MurderShow.class);
        startActivity(intent);
    }
    public void rape(View view){
        Intent intent = new Intent(MainActivity.this,RapeShow.class);
        startActivity(intent);
    }
    public void corruption(View view){
        Intent intent = new Intent(MainActivity.this,CorruptionShow.class);
        startActivity(intent);
    }
    public void illegal(View view){
        Intent intent = new Intent(MainActivity.this,IllegalShow.class);
        startActivity(intent);
    }
    public void sports(View view){
        Intent intent = new Intent(MainActivity.this,SportsShow.class);
        startActivity(intent);
    }
    public void robbery(View view){
        Intent intent = new Intent(MainActivity.this,RobberyShow.class);
        startActivity(intent);
    }
    public void review(View view){
        Intent intent = new Intent(MainActivity.this,Review.class);
        startActivity(intent);
    }
}

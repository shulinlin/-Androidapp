package com.example.a57407.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView mylistview;
    String[] items;
    String[] descriptions;
    String[] prices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        mylistview = (ListView) findViewById(R.id.mylistview);
        items = res.getStringArray(R.array.items);
        descriptions = res.getStringArray(R.array.descriptions);
        prices = res.getStringArray(R.array.prices);

        ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, descriptions);
        mylistview.setAdapter(itemAdapter);

        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent show = new Intent(getApplicationContext(), DetailActivity.class);
                show.putExtra("com.example.a57407.ITEM_INDEX",i);
                startActivity(show);
            }
        });
    }
}

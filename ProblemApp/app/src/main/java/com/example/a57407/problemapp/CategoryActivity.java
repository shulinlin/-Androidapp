package com.example.a57407.problemapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class CategoryActivity extends AppCompatActivity {
    ListView myListView;
    String[] items;
    String[] numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        items = res.getStringArray(R.array.category);
        numbers = res.getStringArray(R.array.number);
//        myListView.setAdapter(new ArrayAdapter<String>(this,R.layout.my_listview_detail,items));
        ItemAdapter itemAdapter = new ItemAdapter(this,items,numbers);
        myListView.setAdapter(itemAdapter);

    }
}

package com.example.a57407.problemapp;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity {

    ItemAdapter itemAdapter;
    Context thiscontext;
    ListView myListView;
    TextView progressTextView;
    Map<String,Double> fruitmap = new LinkedHashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.detiallistView);
        progressTextView = (TextView)findViewById(R.id.progressTextView);
        thiscontext = this;

        progressTextView.setText("");

    }
}

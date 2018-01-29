package com.example.a57407.problemapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 57407 on 2018/1/20.
 */

public class Detail_ItemAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    Map<String,Double> map;
    List<String> items;
    List<Double> numbers;

    public Detail_ItemAdapter(Context c, Map m){
        map=m;
        items = new ArrayList<String>(map.keySet());
        numbers = new ArrayList<Double>(map.values());
        mInflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return map.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.my_listview_detail,null);
        TextView itemTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView numberTextView = (TextView)v.findViewById(R.id.PriceTextView);

        String detailitemname = items.get(i);
        Double number = numbers.get(i);
        itemTextView.setText(detailitemname);
        numberTextView.setText(number.toString());
        return v;
    }
}
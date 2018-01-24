package com.example.a57407.problemapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by 57407 on 2018/1/20.
 */

public class ItemAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    String[] items;
    String[] numbers;

    public ItemAdapter(Context c, String[] i,String[] n){
        items=i;
        numbers = n;
        mInflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.my_listview_detail,null);
        TextView itemTextView = (TextView) v.findViewById(R.id.itemnameTextView);
        TextView numberTextView = (TextView)v.findViewById(R.id.numTextView);

        String itemname = items[i];
        String number = numbers[i];
        itemTextView.setText(itemname);
        numberTextView.setText(number);
        return v;
    }
}

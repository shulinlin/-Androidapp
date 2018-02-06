package com.example.a57407.problemapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by 57407 on 2018/2/5.
 */

public class Switch_chooseAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    String[] switches;
    String[] numbers;

    public Switch_chooseAdapter(Context c, String[] s, String[] n){
        switches = s;
        numbers = n;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return switches.length;
    }

    @Override
    public Object getItem(int i) {
        return switches[i];
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

        String switch_name = switches[i];
        String number = numbers[i];
        itemTextView.setText(switch_name);
        numberTextView.setText(number);
        return v;
    }
}

package com.example.a57407.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by 57407 on 2018/1/6.
 */

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] items;
    String[] descriptions;
    String[] prices;

    public ItemAdapter(Context c, String[] i, String[] p, String[] d){
        items = i;
        prices = p;
        descriptions = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        View v = mInflater.inflate(R.layout.my_listview_details,null);
        TextView name = (TextView) v.findViewById(R.id.nametextview);
        TextView pricestext = (TextView) v.findViewById(R.id.pricetextview);
        TextView description = (TextView) v.findViewById(R.id.descriptiontextview);

        String Name = items[i];
        String des = descriptions[i];
        String cost = prices[i];

        name.setText(Name);
        pricestext.setText(cost);
        description.setText(des);

        return v;
    }
}

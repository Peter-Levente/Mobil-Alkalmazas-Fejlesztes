package com.example.a4_hazi;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class CustomListAdapter extends ArrayAdapter {
    private final Activity context;
    private final Integer[] flags_img;
    private final String[] short_name;
    private final String[] name;
    private final String[] buys;
    private final String[] sells;

    public CustomListAdapter(Activity context, Integer[] flags_img, String[] short_name, String[] name, String[] buys, String[] sells) {
        super(context, R.layout.activity_custom_list_view, flags_img);
        this.context = context;
        this.flags_img = flags_img;
        this.short_name = short_name;
        this.name = name;
        this.buys = buys;
        this.sells = sells;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.activity_custom_list_view, null, true);

        ImageView image = rowView.findViewById(R.id.image);
        TextView shortname = rowView.findViewById(R.id.short_name);
        TextView long_name = rowView.findViewById(R.id.name);
        TextView buy = rowView.findViewById(R.id.buy);
        TextView sell = rowView.findViewById(R.id.sell);

        image.setImageResource(flags_img[position]);
        shortname.setText(short_name[position]);
        long_name.setText(name[position]);
        buy.setText(buys[position]);
        sell.setText(sells[position]);

        return rowView;
    }
}
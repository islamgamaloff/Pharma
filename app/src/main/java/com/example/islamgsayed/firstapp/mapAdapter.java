package com.example.islamgsayed.firstapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Islam.G sayed on 6/22/2018.
 */

public class mapAdapter  extends BaseAdapter{

    private Context context;
    private ArrayList<String> datalist;
    private ArrayList<String> datalist2;
//    private ArrayList<String> num;
//    private ArrayList<String> pic_list;
//    private int xx=0;
    private TextView name_textView;
    private TextView  description_imageView;
    private TextView Num;
    private ImageView imageView;


    public mapAdapter(Context context, ArrayList<String> datalist, ArrayList<String> datalist2) {
        this.context = context;
        this.datalist = datalist;
        this.datalist2 = datalist2;

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}

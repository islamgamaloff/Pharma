package com.example.islamgsayed.firstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class kemyaadapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> datalist;
    private ArrayList<String> datalist2;
    private ArrayList<String> num;
    private ArrayList<String> pic_list;
    private int xx=0;
    private TextView name_textView;
    private TextView  description_imageView;
    private TextView Num;
    private ImageView imageView;


    public kemyaadapter(Context context1, ArrayList<String> list, ArrayList<String> datalist2)
    {
        context=context1;
        datalist=list;
        this.datalist2=datalist2;



    }
    public kemyaadapter(Context context1, ArrayList<String> list, ArrayList<String> datalist2, ArrayList<String> num)
    {
        context=context1;
        datalist=list;
        this.datalist2=datalist2;
        this.num=num;

    }


    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int i) {
        return datalist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 =inflater.inflate(R.layout.kemyalist, viewGroup,false);
      //  imageView=(ImageView) view1.findViewById(R.id.packageImage);
        name_textView=(TextView) view1.findViewById(R.id.Apk_Name);
        description_imageView=(TextView) view1.findViewById(R.id.Apk_Package_Name);
        Num = (TextView) view1.findViewById(R.id.num);


        description_imageView.setText(datalist2.get(i));
        name_textView.setText(datalist.get(i));
        Num.setText(num.get(i));


        return view1;
    }
}

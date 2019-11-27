package com.example.islamgsayed.firstapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Islam.G sayed on 6/14/2018.
 */

public class zabk extends RecyclerView.Adapter<zabk.ViewHolder> {
    ArrayList<phinfo>products;
    Context context;

    public zabk(ArrayList<phinfo> products, Context context) {
        this.products = products;
        this.context = context;
    }





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.itemform,parent,false);
        return new zabk.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        phinfo product=products.get(position);
        holder.name.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,price;
        public ViewHolder(View itemView) {
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.nameDrags);
            price=(TextView)itemView.findViewById(R.id.priceDrags);

        }
    }
//    private Context mcontext;
//    private List<product> mproductslist;
//
//    public productlistAdapter(Context mcontext, List<product> mproductslist) {
//        this.mcontext = mcontext;
//        this.mproductslist = mproductslist;
//    }
//
//    @Override
//    public int getCount() {
//        return mproductslist.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return mproductslist.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View v = View.inflate(mcontext,R.layout.listviewcontent,null);
//        TextView tvname= v.findViewById(R.id.tvname);
//        TextView tvprice = v.findViewById(R.id.tvprice);
//
//        // set text to textview
//        tvname.setText(mproductslist.get(position).getName());
//        tvname.setText(String.valueOf(mproductslist.get(position).getPrice()+" $"));
//
//        //save to tag
//        v.setTag(mproductslist.get(position).getId());
//
//
//        return v;
//    }
}

package com.example.islamgsayed.firstapp;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Islam.G sayed on 6/22/2018.
 */

public class skindesies extends RecyclerView.Adapter<skindesies.ViewHolder> {

    ArrayList<product> products;
    Context context;

    public skindesies(ArrayList<product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public skindesies.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.reycleview,parent,false);
         return new ViewHolder(v,context,products);
    }
    @Override
    public void onBindViewHolder(@NonNull skindesies.ViewHolder holder, int position) {
        product product=products.get(position);
        holder.name.setText(product.getName());
        holder.des.setText(product.getDesciption());
        holder.price.setText(product.getSymptom());
      //  holder.price.setText(product.getPrice());


    }

    @Override
    public int getItemCount() {
        return products.size();

    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name, price , des;
        TextView textView, textView1 ,textView2;
        ArrayList<product> contacts = new ArrayList<product>();
        Context context;


        public ViewHolder(View itemView, Context context, ArrayList<product> contacts) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.context = context;
            this.contacts = contacts;
            textView = itemView.findViewById(R.id.sender);
            textView1 = itemView.findViewById(R.id.content);
            //  ITEM_FORM = (CardView) itemView.findViewById(R.id.ITEM_FORM);
           // name = (TextView) itemView.findViewById(R.id.nameDrags);
//            price = (TextView) itemView.findViewById(R.id.priceDrags);
            des = (TextView) itemView.findViewById(R.id.hidden1);
            price = (TextView) itemView.findViewById(R.id.hidden2);
            name = (TextView) itemView.findViewById(R.id.disname);

        }

        @Override
        public void onClick(View v) {
            int postion = getAdapterPosition();


            product product = this.contacts.get(postion);
            String kareem = name.getText().toString();
            String ezzat = des.getText().toString();
        String islam = price.getText().toString();
            View view1 = LayoutInflater.from(v.getContext()).inflate(R.layout.activity_tgrba, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            TextView title_text_view = view1.findViewById(R.id.sender);
            TextView message_text_view = view1.findViewById(R.id.content);
            TextView mes = view1.findViewById(R.id.desss);
            ImageView imageView = view1.findViewById(R.id.imageView4);
            imageView.setImageResource(R.drawable.allergy_icon);
            message_text_view.setTextSize(15);
            mes.setTextSize(15);
            title_text_view.setText(kareem);
            message_text_view.setText(islam);
            mes.setText(ezzat);
            builder.setNegativeButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
//            builder.setPositiveButton("cancel", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//
//                }
//            });
            builder.setView(view1);
            builder.show();


        }

        }
    }

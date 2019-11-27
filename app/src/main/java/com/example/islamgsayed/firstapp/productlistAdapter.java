package com.example.islamgsayed.firstapp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.EventLogTags;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Islam.G sayed on 6/14/2018.
 */

public class productlistAdapter extends RecyclerView.Adapter<productlistAdapter.ViewHolder> {

    //    private AdapterView.OnItemClickListener onItemClickListener;
    ArrayList<product> products;
    Context context;
    ArrayList<String> hazems = new ArrayList();
//    Dialog mydialog;


    public productlistAdapter(ArrayList<product> products, Context context) {
        this.products = products;
        this.context = context;
    }


    @NonNull
    @Override
    public productlistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.itemform, parent, false);
        final ViewHolder viewHolder = new ViewHolder(v, context, products);
        return new ViewHolder(v, context, products);
    }

    @Override
    public void onBindViewHolder(@NonNull productlistAdapter.ViewHolder holder, int position) {

        product product = products.get(position);
        hazems.add(product.getName());
//        holder.name.setText(product1.getName());
//        holder.price.setText(product1.getPrice());
        holder.name.setText(product.getName());
        holder.price.setText(product.getPrice());


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //  private CardView ITEM_FORM;
        TextView name, price;
        TextView textView, textView1, textView2;
        ArrayList<product> contacts = new ArrayList<product>();
        Context context;

        public ViewHolder(View itemView, Context context, ArrayList<product> contacts) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.context = context;

            this.contacts = contacts;
            textView = itemView.findViewById(R.id.sender);
            textView1 = itemView.findViewById(R.id.content);
            textView2 = itemView.findViewById(R.id.deasese);
            //  ITEM_FORM = (CardView) itemView.findViewById(R.id.ITEM_FORM);
            name = (TextView) itemView.findViewById(R.id.nameDrags);
            price = (TextView) itemView.findViewById(R.id.priceDrags);

        }

        @Override
        public void onClick(View v) {

            int postion = getAdapterPosition();


            final product product = this.contacts.get(postion);
            String kareem = name.getText().toString();
            String islam = price.getText().toString();

//            Intent intent= new Intent(context,tgrba.class);
//            intent.putExtra("Name",kareem);
//            intent.putExtra("Price ",product.getPrice());
//            this.context.startActivity(intent);
//            Toast.makeText(v.getContext(),kareem,Toast.LENGTH_LONG).show();
            View view1 = LayoutInflater.from(v.getContext()).inflate(R.layout.activity_tgrba2, null);
            final AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            TextView title_text_view = view1.findViewById(R.id.sender);
            TextView message_text_view = view1.findViewById(R.id.content);
            final TextView quantity = view1.findViewById(R.id.textViewForCount);
            Button minusBtn = view1.findViewById(R.id.minusButton);
            Button plusBtn = view1.findViewById(R.id.plusButton);
            Button addbutton = view1.findViewById(R.id.AddButton);
            title_text_view.setText(kareem);
            message_text_view.setText(islam);
            builder.setView(view1);
            final AlertDialog dialog = builder.show();


            minusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer quan = Integer.parseInt(quantity.getText().toString());
                    if (quan != 1)
                        quantity.setText(String.valueOf(quan - 1));
                }
            });

            plusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer quan = Integer.parseInt(quantity.getText().toString());
                    quantity.setText(String.valueOf(quan + 1));
                }
            });

            addbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CartItem cartItem = new CartItem(product, Integer.parseInt(quantity.getText().toString()));
                    StaticConfig.cart.add(cartItem);
                    Toast.makeText(context, "Item Added Successfully", Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                }
            });

            builder.setNegativeButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setPositiveButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });


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

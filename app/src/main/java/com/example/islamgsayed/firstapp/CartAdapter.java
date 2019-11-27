package com.example.islamgsayed.firstapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.VH> {

    ArrayList<CartItem> cartItems;
    Context context;

    public CartAdapter(ArrayList<CartItem> cartItems, Context context) {
        this.cartItems = cartItems;
        this.context = context;
    }

    @NonNull
    @Override

    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemform, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        CartItem cartItem = cartItems.get(position);
        holder.updateUI(cartItem);
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    class VH extends RecyclerView.ViewHolder {

        TextView name, price;

        public VH(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameDrags);
            price = itemView.findViewById(R.id.priceDrags);
        }

        public void updateUI(CartItem cartItem) {
            name.setText(cartItem.product.getName() + ", Quantity: " + String.valueOf(cartItem.quantity));
            price.setText(cartItem.product.getPrice());
        }
    }
}

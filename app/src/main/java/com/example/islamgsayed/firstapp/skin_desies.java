package com.example.islamgsayed.firstapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Islam.G sayed on 6/22/2018.
 */

public class skin_desies extends Fragment {
    View view;
    RecyclerView recyclerView;
    skindesies skindesiess;
    ArrayList<product> mproducts;
    DatabaseReference databaseReference;

    public skin_desies(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tablets, container, false);
        recyclerView = view.findViewById(R.id.myRecycle1);
        mproducts = new ArrayList<>();
        skindesiess = new skindesies(mproducts, getActivity());
        recyclerView.setAdapter(skindesiess);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Diseases");

        databaseReference.child("skin desies").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot drags : dataSnapshot.getChildren()) {
                    product products = drags.getValue(product.class);
                    drags.child("").getValue().toString();
                    mproducts.add(products);


                }
                skindesiess.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        return view;
    }
    }


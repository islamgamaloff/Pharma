package com.example.islamgsayed.firstapp;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class popularDiseses extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    ArrayList<product> mproducts;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_diseses);
        productlistAdapter productlistAdapters;

        mproducts=new ArrayList<>();

        tabLayout = findViewById(R.id.tablayoutPolpularDis);
        viewPager = findViewById(R.id.viewpager_PolpularDis);
        productlistAdapters=new productlistAdapter(mproducts,this);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Diseases");
        databaseReference.child("skin desies").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot drags:dataSnapshot.getChildren()){
                    product products=drags.getValue(product.class);
                    mproducts.add(products);


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        viewpageradapter adapter = new viewpageradapter(getSupportFragmentManager());
        adapter.addfragment(new skin_desies(),"امراض شائعه");

        //adapter.addfragment(new test(),"tany");
        //adapter.addfragment(new profileHistory(),"Ampoule");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);



    }
}

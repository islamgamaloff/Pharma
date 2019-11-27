package com.example.islamgsayed.firstapp;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.ErrnoException;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    ViewPager viewPager;
    kemyaadapter kemyaadapter;
    DatabaseReference databaseReference;
    ArrayList<phinfo> mproducts;
    zabk productlistAdapters;
    ArrayList<String> namme = new ArrayList<>();
    ArrayList<String> adddresss = new ArrayList<>();
    ArrayList<String> Number= new ArrayList<>();
    ListView kemya;

    static String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spinner = findViewById(R.id.spinnr);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        productlistAdapters = new zabk(mproducts, this);


        kemya = findViewById(R.id.listkemya);
// hna bygeb el child ely esmo pharmacies ely mn el database

        databaseReference = FirebaseDatabase.getInstance().getReference().child("pharmacies");

        updateListView();


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();


        kemya.invalidateViews();
        //kemya.clearTextFilter();
        name = parent.getItemAtPosition(position).toString();
        updateListView();


    }

    private void updateListView() {
        databaseReference.child(name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                namme.clear();
                adddresss.clear();
                Number.clear();

                for (DataSnapshot drags : dataSnapshot.getChildren()) {
                    namme.add(drags.child("name").getValue(String.class));
                    adddresss.add(drags.child("address").getValue(String.class));
                    Number.add(drags.child("Number").getValue(String.class));
                }

                kemyaadapter = new kemyaadapter(getApplicationContext(), namme, adddresss, Number);
                kemya.setAdapter(kemyaadapter);
                kemyaadapter.notifyDataSetChanged();


                //  productlistAdapters.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

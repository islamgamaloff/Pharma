package com.example.islamgsayed.firstapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PharmacyDetails extends AppCompatActivity {

    FloatingActionButton cartFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pharmacy_details);
        cartFab = findViewById(R.id.cart_fab);

        StaticConfig.cart.clear();

        cartFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PharmacyDetails.this, cart.class));
            }
        });

        getSupportFragmentManager().beginTransaction().add(R.id.ph_container, new medicineDic()).commit();
    }
}

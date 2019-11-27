package com.example.islamgsayed.firstapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registrationform extends AppCompatActivity implements View.OnClickListener {

    private EditText FirstName;
    private EditText LastName;
    private EditText EditTextemail;
    private EditText EditTextpassword;
    private EditText EditTextrepassword;
    private EditText EditTextphonenumber;
    private EditText EditTextage;
    private Button Btnback;
    private Button Btnregister;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private String User_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationform);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), navdrawer.class));
        }
        //progressDialog= new ProgressDialog(this);

        FirstName = findViewById(R.id.firstname);
        LastName = findViewById(R.id.lastname);
        EditTextemail = findViewById(R.id.edittextemail);
        EditTextpassword = findViewById(R.id.edittextpassword);
        EditTextrepassword = findViewById(R.id.editTextrepassword);
        EditTextphonenumber = findViewById(R.id.editTextPhonenumber);
        EditTextage = findViewById(R.id.editTextage);
        Btnback = findViewById(R.id.btnback);
        Btnregister = findViewById(R.id.btnregister);

        Btnregister.setOnClickListener(this);
        Btnback.setOnClickListener(this);

    }
    private void registerUser() {

        String firstname = FirstName.getText().toString().trim();
        String lastname = LastName.getText().toString().trim();
        String email = EditTextemail.getText().toString().trim();
        String password = EditTextpassword.getText().toString().trim();
        String repassword = EditTextrepassword.getText().toString().trim();
        String Phonenumber = EditTextphonenumber.getText().toString().trim();
        String age = EditTextage.getText().toString().trim();

        if (TextUtils.isEmpty(firstname)) {
            Toast.makeText(this, "please enter first name ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(lastname)) {
            Toast.makeText(this, "please enter last name ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "please enter email ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "please enter password ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(repassword)) {
            Toast.makeText(this, "please re-type password ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Phonenumber)) {
            Toast.makeText(this, "please enter phone number ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(age)) {
            Toast.makeText(this, "please enter age ", Toast.LENGTH_SHORT).show();
            return;
        }
        // ProgressDialog.setMessage("done");
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    saveUserInformatio();
                    finish();
                    startActivity(new Intent(getApplicationContext(), navdrawer.class));
                    // Toast.makeText(registrationform.this,"done ",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(registrationform.this, "something wronge ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void saveUserInformatio() {
        String name = FirstName.getText().toString().trim();

        String Email = EditTextemail.getText().toString().trim();
        String password = EditTextpassword.getText().toString().trim();
        String Phone = EditTextphonenumber.getText().toString().trim();
        String age = EditTextage.getText().toString().trim();

        String id = firebaseAuth.getCurrentUser().getUid();
        UserInformation userInformation = new UserInformation(name, Email, Phone, age);
        databaseReference.child(id).setValue(userInformation);


    }

    @Override
    public void onClick(View v) {
        if (v == Btnregister) {
            registerUser();

        }
        if (v == Btnback) {
            //will open login activity
            startActivity(new Intent(this, loginActivity.class));
        }
    }

}

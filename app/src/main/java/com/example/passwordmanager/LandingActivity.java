package com.example.passwordmanager;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.passwordmanager.databinding.ActivityLandingBinding;

public class LandingActivity extends AppCompatActivity {
    // Declaring Custom Variables
    private Button SubmitButton;

    userData userdata;
    private boolean hasOldAccount;
    private String password;

    public void submit(View view){
        EditText userEt = findViewById(R.id.loginUsername);
        EditText passEt = findViewById(R.id.loginPassword);
        if(!hasOldAccount) {
            userData.newLogin(userEt.getText().toString(), passEt.getText().toString());
            Intent intent = new Intent(LandingActivity.this, HomeActivity.class);
            startActivity(intent);
        } else{
            if (passEt.getText().toString().equals(password)){
                // logged in
                Intent intent = new Intent(LandingActivity.this, HomeActivity.class);
                startActivity(intent);
            } else{
                // Wrong password
                Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getSupportActionBar().setTitle("Password Manager");
        setContentView(R.layout.activity_landing);

        userdata = new userData(this);

        login user = userData.getLoginUser();

        if (user == null) {
            // new login
            hasOldAccount = false;
        } else {
            // old login
            hasOldAccount = true;
            ((TextView) findViewById(R.id.greetings)).setText("Welcome, " + user.userName);

            ((EditText) findViewById(R.id.loginUsername)).setVisibility(View.INVISIBLE);
            ((EditText) findViewById(R.id.loginUsername)).setHeight(0);
            ((EditText) findViewById(R.id.loginPassword)).setText(user.password);
            password = user.password;
        }


    }
}
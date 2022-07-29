package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {

    /*
    * Display Info TextView/ImageView
    * */
    // Password Strength
    private ProgressBar accountPassStrength;

    // Upper Card
    private ImageView accountImage;
    private TextView accountPlatform;
    private TextView accountId;


    // Main Card
    private TextView accountUserName;
    private TextView accountMail;
    private TextView accountPassword;
    private TextView accountWebsite;

    // Additional info Card
    private TextView accountAdditionalInfo;

    // bottom Card
    private TextView accountCreationDate;
    private TextView accountLastEditedDate;

    /*
    * Interactions Buttons
    * */
    // Top Nav
    private ImageButton editAccount;
    private ImageButton deleteAccount;
    private ImageButton favoriteAccount;

    // Copy Account Details
    private ImageButton copyUserName;
    private ImageButton copyMail;
    private ImageButton copyPassword;
    private ImageButton copyWebsite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // TODO: Get intent from other activity to display image
        // TODO: Pass Array of account through intent



    }
}
package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;

public class EditActivity extends AppCompatActivity {

    private ProgressBar accountPassStrength;

    private EditText accountPlatform;
    private EditText accountUserName;
    private EditText accountMail;
    private EditText accountPassword;
    private EditText accountWebsite;
    private EditText accountAdditionalInfo;

    private ImageView accountImage;

    private TextView accountId;
    private boolean favoriteAccount;
    private int imageId;
    private  int AccountId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();

        int Id = Integer.parseInt(intent.getStringExtra("account_id").toString());

        userData accounts = new userData(this);
        platforms account = accounts.find(Id);

        accountPlatform = findViewById(R.id.account_platform_edit);
        accountUserName = findViewById(R.id.account_username_edit);
        accountMail = findViewById(R.id.account_mail_edit);
        accountPassword = findViewById(R.id.account_password_edit);
        accountWebsite = findViewById(R.id.account_website_edit);
        accountAdditionalInfo = findViewById(R.id.account_additional_info_edit);
        accountPassStrength = findViewById(R.id.progressBar);

        accountImage = findViewById(R.id.account_image);
        accountId = findViewById(R.id.account_id_edit2);

        PasswordStrength passwordStrength = new PasswordStrength(account.Password);
        accountPassStrength.setProgress(passwordStrength.Percent());

        String platform = account.PlatformName.toLowerCase(Locale.ROOT);
        switch (platform){
            case "google":
                imageId = R.drawable.google_logo;
                break;
            case "discord":
                imageId = R.drawable.discord_logo;
                break;
            case "facebook":
                imageId = R.drawable.facebook_logo;
                break;
            case "instagram":
                imageId = R.drawable.instagram_logo;
                break;
            case "microsoft":
                imageId = R.drawable.microsoft_logo;
                break;
            case "playstation":
                imageId = R.drawable.playstation_logo;
                break;
            case "snapchat":
                imageId = R.drawable.snapchat_logo;
                break;
            case "steam":
                imageId = R.drawable.steam_logo;
                break;
            case "twitter":
                imageId = R.drawable.twitter_logo;
                break;
            case "xbox":
                imageId = R.drawable.xbox_logo;
                break;
            default:
                imageId = R.drawable.android_logo;
                break;
        }



        accountImage.setImageResource(imageId);


        accountPlatform.setText(account.PlatformName);
        accountId.setText(String.format("%d", account.id));
        AccountId = account.id;
        accountUserName.setText(account.UserName);
        accountMail.setText(account.Email);
        accountPassword.setText(account.Password);
        accountWebsite.setText(account.Website);
        accountAdditionalInfo.setText(account.AdditionalInfo);

        favoriteAccount = account.Favorite;
    }

    public void cancelChanges(View view) {
        finish();
    }

    public void saveChanges(View view) {
        accountPlatform = findViewById(R.id.account_platform_edit);
        accountUserName = findViewById(R.id.account_username_edit);
        accountMail = findViewById(R.id.account_mail_edit);
        accountPassword = findViewById(R.id.account_password_edit);
        accountWebsite = findViewById(R.id.account_website_edit);
        accountAdditionalInfo = findViewById(R.id.account_additional_info_edit);



        userData.UpdateAll(Integer.parseInt(accountId.getText().toString()), accountPlatform.getText().toString(), accountUserName.getText().toString(), accountMail.getText().toString(), accountPassword.getText().toString(), accountWebsite.getText().toString(), accountAdditionalInfo.getText().toString(), favoriteAccount);


        finish();
    }


}
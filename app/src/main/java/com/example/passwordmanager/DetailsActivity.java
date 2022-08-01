package com.example.passwordmanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    // Todo: load from db everytime this activity is open its better way
    // TODO: onresume update data so data edited will show


    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        int Id = Integer.parseInt(intent.getStringExtra("account_id").toString());
        int accountImageID = Integer.parseInt(intent.getStringExtra("account_image").toString());

        userData accounts = new userData(this);
        platforms account = accounts.find(Id);

        AccountId = Id;

        PasswordStrength passwordStrength = new PasswordStrength("account.Password");
        accountPassStrength.setProgress(passwordStrength.Percent());

        accountImage.setImageResource(accountImageID);
        accountPlatform.setText(account.PlatformName);
        accountId.setText(String.format("%d", account.id));

        accountUserName.setText(account.UserName);
        accountMail.setText(account.Email);

        password = account.Password;
        String text = "";

        for (int x = 0; x < password.length(); x++) {
            text += "⚫";
        }
        accountPassword.setText(text);

        accountWebsite.setText(account.Website);
        accountAdditionalInfo.setText(account.AdditionalInfo);

        accountCreationDate.setText(account.CreationDate);
        accountLastEditedDate.setText(account.EditDate);

        favoriteAccount = account.Favorite;


        copyUserName = findViewById(R.id.account_username_copy);
        copyMail = findViewById(R.id.account_mail_Copy);
        copyPassword = findViewById(R.id.account_password_copy);
        copyWebsite = findViewById(R.id.account_website_copy);


        copyUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("username", account.UserName);
                clipboard.setPrimaryClip(clipData);

                Toast.makeText(DetailsActivity.this, "User Name Copied", Toast.LENGTH_SHORT).show();

            }
        });
        copyMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Email", account.Email);
                clipboard.setPrimaryClip(clipData);
                Toast.makeText(DetailsActivity.this, "User Name Copied", Toast.LENGTH_SHORT).show();
            }
        });
        copyPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Password", account.Password);
                clipboard.setPrimaryClip(clipData);
                Toast.makeText(DetailsActivity.this, "User Name Copied", Toast.LENGTH_SHORT).show();

            }
        });
        copyWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("username", account.Website);
                clipboard.setPrimaryClip(clipData);
                Toast.makeText(DetailsActivity.this, "User Name Copied", Toast.LENGTH_SHORT).show();

            }
        });

    }


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
//    private ImageButton editAccount;
//    private ImageButton deleteAccount;
//    private ImageButton favoriteAccountButton;

    // Copy Account Details
    private ImageButton copyUserName;
    private ImageButton copyMail;
    private ImageButton copyPassword;
    private ImageButton copyWebsite;

    // show password
//    private ImageView showPassword;

    private boolean favoriteAccount;
    private String password;
    private boolean password_show;
    private int AccountId;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_details);


        accountPassStrength = findViewById(R.id.progressBar);

        accountImage = findViewById(R.id.account_image);
        accountPlatform = findViewById(R.id.account_platform_edit);
        accountId = findViewById(R.id.account_id_edit);

        accountUserName = findViewById(R.id.account_username);
        accountMail = findViewById(R.id.account_mail);
        accountPassword = findViewById(R.id.account_password);
        accountWebsite = findViewById(R.id.account_website);

        accountAdditionalInfo = findViewById(R.id.account_additional_info);

        accountCreationDate = findViewById(R.id.account_created);
        accountLastEditedDate = findViewById(R.id.account_last_created);


        // TODO: Get intent from other activity to display image
        // TODO: Load data from db find id
        Intent intent = getIntent();
        int Id = Integer.parseInt(intent.getStringExtra("account_id").toString());
        int accountImageID = Integer.parseInt(intent.getStringExtra("account_image").toString());

        userData accounts = new userData(this);
        platforms account = accounts.find(Id);

        AccountId = Id;

        PasswordStrength passwordStrength = new PasswordStrength("account.Password");
        accountPassStrength.setProgress(passwordStrength.Percent());

        accountImage.setImageResource(accountImageID);
        accountPlatform.setText(account.PlatformName);
        accountId.setText(String.format("%d", account.id));

        accountUserName.setText(account.UserName);
        accountMail.setText(account.Email);

        password = account.Password;
        String text = "";

        for (int x = 0; x < password.length(); x++) {
            text += "⚫";
        }
        accountPassword.setText(text);

        accountWebsite.setText(account.Website);
        accountAdditionalInfo.setText(account.AdditionalInfo);

        accountCreationDate.setText(account.CreationDate);
        accountLastEditedDate.setText(account.EditDate);

        favoriteAccount = account.Favorite;


        copyUserName = findViewById(R.id.account_username_copy);
        copyMail = findViewById(R.id.account_mail_Copy);
        copyPassword = findViewById(R.id.account_password_copy);
        copyWebsite = findViewById(R.id.account_website_copy);


        copyUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("username", account.UserName);
                clipboard.setPrimaryClip(clipData);

                Toast.makeText(DetailsActivity.this, "User Name Copied", Toast.LENGTH_SHORT).show();

            }
        });
        copyMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Email", account.Email);
                clipboard.setPrimaryClip(clipData);
                Toast.makeText(DetailsActivity.this, "User Name Copied", Toast.LENGTH_SHORT).show();
            }
        });
        copyPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Password", account.Password);
                clipboard.setPrimaryClip(clipData);
                Toast.makeText(DetailsActivity.this, "User Name Copied", Toast.LENGTH_SHORT).show();

            }
        });
        copyWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("username", account.Website);
                clipboard.setPrimaryClip(clipData);
                Toast.makeText(DetailsActivity.this, "User Name Copied", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userData.UpdateFavorite(AccountId, favoriteAccount);

    }

    public void favoriteCurrentAccount(View view){
        // TODO: Change db favorite account bool or create onDestroy to save whole account data

        if(favoriteAccount) {
            ((ImageButton) view).setImageResource(R.drawable.ic_baseline_star_selected);
        } else {
            ((ImageButton) view).setImageResource(R.drawable.ic_baseline_star_notselected);
        }
        favoriteAccount = !favoriteAccount;
    }

    public void deleteAccount(View view){
        ShowAlertDialog showAlertDialog = new ShowAlertDialog("Delete", "Are You Sure You Wanna Delete The Account?", AccountId);

        showAlertDialog.show(getSupportFragmentManager(), "Alert dialog");

        boolean userInput = showAlertDialog.userInput;
/*
        if (userInput){
            userData.Delete(AccountId);
            finish();

            Toast.makeText(this, "Account Deleted", Toast.LENGTH_SHORT).show();
        }*/
    }

    public void ShowPassword(View view) {

        if(password_show) {
            String text = "";

            for (int x = 0; x < password.length(); x++) {
                text += "⚫";
            }
            accountPassword.setText(text);

            ((ImageButton) view).setImageResource(R.drawable.ic_baseline_visibility_24);


            password_show = !password_show;
        } else{
            accountPassword.setText(password);
            password_show = !password_show;
            ((ImageButton) view).setImageResource(R.drawable.ic_baseline_visibility_off_24);

        }
    }

    public void EditAccount(View view) {
        Intent intent = new Intent(DetailsActivity.this, EditActivity.class);
        intent.putExtra("account_id", String.format("%d", AccountId));
        startActivity(intent);
    }
}
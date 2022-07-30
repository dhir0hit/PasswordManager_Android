package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    private EditText accountPlatform;
    private EditText accountUserName;
    private EditText accountMail;
    private EditText accountPassword;
    private EditText accountWebsite;
    private EditText accountAdditionalInfo;

    private TextView accountId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_edit);

        Intent intent = new Intent();
        // TODO: load account details from db using id
        intent.getStringExtra("Id");

        String[] accountDetail = {"sample Platform", "sample Id", "sample username", "sample mail", "sample password", "sample website", "sample additional info", "true"};

        accountPlatform = findViewById(R.id.account_platform_edit);
        accountUserName = findViewById(R.id.account_username_edit);
        accountMail = findViewById(R.id.account_mail_edit);
        accountPassword = findViewById(R.id.account_password_edit);
        accountWebsite = findViewById(R.id.account_website_edit);
        accountAdditionalInfo = findViewById(R.id.account_additional_info_edit);

        accountId = findViewById(R.id.account_id_edit2);

        accountPlatform.setText(accountDetail[0]);
        accountId.setText(accountDetail[1]);
        accountUserName.setText(accountDetail[2]);
        accountMail.setText(accountDetail[3]);
        accountPassword.setText(accountDetail[4]);
        accountWebsite.setText(accountDetail[5]);
        accountAdditionalInfo.setText(accountDetail[6]);


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

        // TODO: Save things to database

        finish();
    }

    public void deleteAccount(View view){
        ShowAlertDialog showAlertDialog = new ShowAlertDialog("Delete", "Are You Sure You Wanna Delete The Account?");

        showAlertDialog.show(getSupportFragmentManager(), "Alert dialog");

        boolean userInput = showAlertDialog.userInput;

        // TODO: delete account from database if userInput true
        if (userInput){
            Intent intent = new Intent(EditActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }
}
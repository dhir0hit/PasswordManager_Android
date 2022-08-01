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
    private boolean IsFavorite;



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

        accountId = findViewById(R.id.account_id_edit2);

        accountPlatform.setText(account.PlatformName);
        accountId.setText(String.format("%d", account.id));
        accountUserName.setText(account.UserName);
        accountMail.setText(account.Email);
        accountPassword.setText(account.Password);
        accountWebsite.setText(account.Website);
        accountAdditionalInfo.setText(account.AdditionalInfo);


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



        userData.UpdateAll(Integer.parseInt(accountId.getText().toString()), accountPlatform.getText().toString(), accountUserName.getText().toString(), accountMail.getText().toString(), accountPassword.getText().toString(), accountWebsite.getText().toString(), accountAdditionalInfo.getText().toString(), IsFavorite);


        finish();
    }

    public void deleteAccount(View view){
        ShowAlertDialog showAlertDialog = new ShowAlertDialog("Delete", accountId.getText().toString());

        showAlertDialog.show(getSupportFragmentManager(), "Alert dialog");

        boolean userInput = showAlertDialog.userInput;

        // TODO: delete account from database if userInput true
        if (userInput){

            userData account = new userData(this);

            account.Delete(Integer.parseInt(accountId.getText().toString()));
            Intent intent = new Intent(EditActivity.this, HomeActivity.class);
            startActivity(intent);

        }

    }
}
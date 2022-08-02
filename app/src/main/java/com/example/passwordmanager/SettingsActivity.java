package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    EditText userEt, passEt;
    Button updatebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        userEt = findViewById(R.id.editUsername);
        passEt = findViewById(R.id.editPassword);
        updatebtn = findViewById(R.id.update);

        userData user_data = new userData(this);
        login user = userData.getLoginUser();

        if (user != null) {
            userEt.setText(user.userName);
            passEt.setText(user.password);
        }

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userEt.getText().toString();
                String password = passEt.getText().toString();


                user_data.updateLogin(username,password);

                finish();
            }
        });
    }
}
package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


public class CreateActivity extends AppCompatActivity {

    EditText idEt, platEt, userEt, passEt, emailEt, websiteEt, infoEt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Create Id
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        platEt = findViewById(R.id.platform);
        userEt = findViewById(R.id.username);
        passEt = findViewById(R.id.password);
        emailEt = findViewById(R.id.email);
        websiteEt = findViewById(R.id.website);
        infoEt = findViewById(R.id.additionalinfo);

        btn = findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPlatform();
            }
        });




    }

    private void addPlatform() {
        String platform = platEt.getText().toString();
        String username = userEt.getText().toString();
        String password = passEt.getText().toString();
        String email = emailEt.getText().toString();
        String website = websiteEt.getText().toString();
        String info = infoEt.getText().toString();


        userData userdata = new userData(this);

        List<platforms> accounts =  userdata.getAll;
        int id = accounts.size() + 1;

        userData.addAccount(id, platform, username, email, password, website, info);

        finish();
        Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show();
    }
}
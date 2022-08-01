package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CreateActivity extends AppCompatActivity {

    MyDatabase db;
    EditText idEt, platEt, userEt, passEt, emailEt, websiteEt, infoEt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        db = MyDatabase.getInstance(this);

        idEt = findViewById(R.id.id);
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
        int id = Integer.valueOf(idEt.getText().toString());
        String platform = platEt.getText().toString();
        String username = userEt.getText().toString();
        String password = passEt.getText().toString();
        String email = emailEt.getText().toString();
        String website = websiteEt.getText().toString();
        String info = infoEt.getText().toString();


        platforms platforms = new platforms(id, platform, username, email, password, website, info);

        db.passDao().insert(platforms);


        finish();


        Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show();
    }
}
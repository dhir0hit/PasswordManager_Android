package com.example.passwordmanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.time.LocalTime;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public class PassListActivity extends AppCompatActivity {
    private LinearLayout CardList;
    private ImageButton BackgroundButton;
    private TextView greeting;
    private ImageView img;
    LocalTime time = LocalTime.now();
    int hour = time.getHour();

    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_passlist);

        Intent intent = new Intent();
        // TODO: use type to filter account and display accounts
        String Type = intent.getStringExtra("type");


        CardList = findViewById(R.id.card_list);
        BackgroundButton = findViewById(R.id.background_button);
        greeting = findViewById(R.id.greeting);
        img = findViewById(R.id.imageView);

        String userGreeting = "";

        if (hour<12 && hour>=6){
            userGreeting = "Good morning";
            img.setImageResource(R.drawable.ic_baseline_wb_sunny_48);
        } else if (hour>=12 && hour<18) {
            userGreeting = "Good afternoon";
            img.setImageResource(R.drawable.ic_baseline_wb_sunny_48);
        } else {
            userGreeting = "Good evening";
            img.setImageResource(R.drawable.ic_baseline_bedtime_48);
        }

        greeting.setText("Hi User, "+userGreeting);

        BackgroundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        /*Card card = new Card(this, "mail@mail.com", "platform", true);
        card.AddTo(CardList);*/

        userData accounts = new userData(this);

        for (platforms account: accounts.getAll){
            Card card = new Card(this, account.id, account.Email, account.PlatformName, account.Favorite);
            card.AddTo(CardList);
        }
    }
}

















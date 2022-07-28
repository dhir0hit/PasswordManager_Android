package com.example.passwordmanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.time.LocalTime;

@RequiresApi(api = Build.VERSION_CODES.O)
public class PassListActivity extends AppCompatActivity {
    private LinearLayout CardList;
    private ImageButton BackgroundButton;
    private TextView greeting;
    private ImageView img;
    LocalTime time = LocalTime.now();
    int hour = time.getHour();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_passlist);

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


        Card card = new Card(this, "mail@mail.com", "platform", true);
        card.AddTo(CardList);

        for (int i=0; i<10;i++){
            card = new Card(this, "mail1@mail.com", "platform1", false);
            card.AddTo(CardList);
        }
    }
}

















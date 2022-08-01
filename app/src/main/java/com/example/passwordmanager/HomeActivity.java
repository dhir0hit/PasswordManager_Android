package com.example.passwordmanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    // Account Numbers
    private TextView totalAccount;
    private TextView totalFavoriteAccount;
    private TextView totalRecentAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

//        userData user_Data = new userData(this);
//         MyDatabase db = user_Data.db;
//        List<platforms> getAll = db.passDao().getAll() ;
//        List<platforms> platformsList = userData.getAll;


        totalAccount = findViewById(R.id.total_account);
        totalFavoriteAccount = findViewById(R.id.total_favorite_account);
        totalRecentAccount = findViewById(R.id.total_recent_account);


        totalAccount.setText("54");
        totalFavoriteAccount.setText("32");
        totalRecentAccount.setText("7");


        // TODO: class.filterAll(favorite or recent) to get all account with specific filter

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void LoadFavorite(View view) {
        Intent intent = new Intent(HomeActivity.this, PassListActivity.class);
        intent.putExtra("type", "favorite");
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void LoadRecent(View view){
        Intent intent = new Intent(HomeActivity.this, PassListActivity.class);
        intent.putExtra("type", "recent");
        startActivity(intent);
    }

    public void CreateAccountActivity(View view){
        Intent intent = new Intent(HomeActivity.this, CreateActivity.class);
        startActivity(intent);
    }
}
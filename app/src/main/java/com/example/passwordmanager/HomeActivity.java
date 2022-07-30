package com.example.passwordmanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

        totalAccount = findViewById(R.id.total_account);
        totalFavoriteAccount = findViewById(R.id.total_favorite_account);
        totalRecentAccount = findViewById(R.id.total_recent_account);


        totalAccount.setText("54");
        totalFavoriteAccount.setText("32");
        totalRecentAccount.setText("7");

        // TODO: class.find(account Name or account id) to find one account from db
        // TODO: class.getAll() to get all the accounts
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
}
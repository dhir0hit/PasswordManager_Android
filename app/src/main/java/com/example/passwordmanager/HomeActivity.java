package com.example.passwordmanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);
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
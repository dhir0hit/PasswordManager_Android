package com.example.passwordmanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
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



        load();
    }

    @Override
    protected void onResume() {
        super.onResume();
        load();
    }

    public void setting(View view){
        Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
        startActivity(intent);
    }



    private void load(){
        totalAccount = findViewById(R.id.total_account);
        totalFavoriteAccount = findViewById(R.id.total_favorite_account);
        totalRecentAccount = findViewById(R.id.total_recent_account);

        userData user_Data = new userData(this);


        int totalSize = user_Data.getAll.size();
        totalAccount.setText(String.valueOf(totalSize));
        int favoriteSize = user_Data.filterAll("favorite").size();
        totalFavoriteAccount.setText(String.valueOf(favoriteSize));
        int recentSize = user_Data.filterAll("recent").size();
        totalRecentAccount.setText(String.valueOf(recentSize));

        TextView overallStrength, strongStrength, normalStrength, weakStrength;
        overallStrength = findViewById(R.id.overall_strength);
        strongStrength = findViewById(R.id.strong_strength);
        normalStrength = findViewById(R.id.normal_strength);
        weakStrength = findViewById(R.id.weak_strength);

        List<Integer> overallPassStrengths = new ArrayList<Integer>(){};
        List<Integer> strongPassStrengths = new ArrayList<Integer>(){};
        List<Integer> normalPassStrengths = new ArrayList<Integer>(){};
        List<Integer> weakPassStrengths = new ArrayList<Integer>(){};
        int overallStrengthPercent, strongStrengthPercent, normalStrengthPercent, weakStrengthPercent;


        for(platforms account: user_Data.getAll){
            PasswordStrength strength = new PasswordStrength(account.Password);
            overallPassStrengths.add(strength.Percent());

            if(strength.Percent()>80){
                strongPassStrengths.add(strength.Percent());
            } else if (strength.Percent()>50){
                normalPassStrengths.add(strength.Percent());
            } else {
                weakPassStrengths.add(strength.Percent());
            }
        }

       /* Integer[] passStrengthList = new Integer[overallPassStrengths.size()];
        Integer[] NormalStrengthList = new Integer[normalPassStrengths.size()];
        Integer[] WeakStrengthList = new Integer[weakPassStrengths.size()];
        Integer[] StrongStrengthList = new Integer[strongPassStrengths.size()];*/
        /*overallPassStrengths.toArray(passStrengthList);*/

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            overallStrengthPercent = (int) strengthCalculaor(overallPassStrengths);
            normalStrengthPercent = normalPassStrengths.size();
            weakStrengthPercent = weakPassStrengths.size();
            strongStrengthPercent = strongPassStrengths.size();


            overallStrength.setText(String.format("%d", overallStrengthPercent) + "%");
            strongStrength.setText(String.format("%d", strongStrengthPercent));
            normalStrength.setText(String.format("%d", normalStrengthPercent));
            weakStrength.setText(String.format("%d", weakStrengthPercent));

            ProgressBar pBar = findViewById(R.id.progressBar2);
            if(overallStrengthPercent>80) {
                pBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
            } else if (overallStrengthPercent>50){
                pBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
            } else {
                pBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
            }
        }



    }

    public double strengthCalculaor(List<Integer> l){
        if(l.size()!=0) {
            int sum = 0;
            for (int i : l) {
                sum += i;
            }
            return sum / l.size();
        }
        return 0;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void LoadAll(View view) {
        Intent intent = new Intent(HomeActivity.this, PassListActivity.class);
        intent.putExtra("type", "all");
        startActivity(intent);
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
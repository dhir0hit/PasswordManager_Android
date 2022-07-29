package com.example.passwordmanager;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

class Card {
    private CardView cardView;
    private LinearLayout linearLayoutHorizontal;
    private ImageView avatarImage;
    private LinearLayout linearLayoutVertical;
    public TextView platformName;
    private TextView userMail;
    private ImageView favoriteIcon;

    private String UserMail;
    private String PlatformName;
    private boolean FavoriteAccount;
    private Context Context;
    private int imageId;

    protected void AddTo(LinearLayout parentView){
        // TODO: Add button to add listener to change page to details
        cardView = new CardView(Context);
        linearLayoutHorizontal = new LinearLayout(Context);
        avatarImage = new ImageView(Context);
        linearLayoutVertical = new LinearLayout(Context);
        platformName = new TextView(Context);
        userMail = new TextView(Context);
        favoriteIcon = new ImageView(Context);

        /* Adding Platform name and Layout Params */
        platformName.setText(PlatformName);
        platformName.setTextSize(24);
        platformName.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        /* Adding User name and Layout Params */
        userMail.setText(UserMail);
        userMail.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        /*
         * Setting Image to avatarImage
         * */
        String platform = "Google".toLowerCase(Locale.ROOT);
        switch (platform){
            case "google":
                imageId = R.drawable.google_logo;
                break;
            case "discord":
                imageId = R.drawable.google_logo;
                break;
            case "facebook":
                imageId = R.drawable.google_logo;
                break;
            case "instagram":
                imageId = R.drawable.google_logo;
                break;
            case "microsoft":
                imageId = R.drawable.google_logo;
                break;
            case "playstation":
                imageId = R.drawable.google_logo;
                break;
            case "snapchat":
                imageId = R.drawable.google_logo;
                break;
            case "steam":
                imageId = R.drawable.google_logo;
                break;
            case "twitter":
                imageId = R.drawable.google_logo;
                break;
            case "xbox":
                imageId = R.drawable.google_logo;
                break;
            default:
                imageId = R.drawable.google_logo;
                break;
        }

        avatarImage.setImageResource(imageId);
        avatarImage.setLayoutParams(new LinearLayout.LayoutParams(300, 180));

        /*
         * Adding Linear Layout Orientation and Layout Params
         * */
        linearLayoutVertical.setOrientation(LinearLayout.VERTICAL);
        linearLayoutVertical.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1));
        linearLayoutVertical.setPadding(0,12,0,12);
        // adding Elements in Linear Layout
        linearLayoutVertical.addView(platformName);
        linearLayoutVertical.addView(userMail);


        /*
         * Using If-Else to change icon and setting on variable favoriteIcon
         * */
        if (FavoriteAccount)
        {favoriteIcon.setImageResource(R.drawable.ic_baseline_star_selected);}
        else
        {favoriteIcon.setImageResource(R.drawable.ic_baseline_star_notselected);}
        favoriteIcon.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        /*
         *
         * Adding Linear Layout Orientation and Params
         * */
        linearLayoutHorizontal.setOrientation(LinearLayout.HORIZONTAL);
        linearLayoutHorizontal.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayoutHorizontal.addView(avatarImage);
        linearLayoutHorizontal.addView(linearLayoutVertical);
        linearLayoutHorizontal.addView(favoriteIcon);

        /*
         *
         *
         * Adding Horizontal Linear Layout in CardView
         * */
        cardView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        cardView.setContentPadding(1,25,20,25);
        cardView.addView(linearLayoutHorizontal);


        cardView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Context, DetailsActivity.class);
                intent.putExtra("account", new String[]{"sample Platform", "sample Id", "sample username", "sample mail", "sample password", "sample website", "sample additional info", "true"});
                intent.putExtra("account_image", String.format("%d", imageId));
                intent.putExtra("creation_date", LocalDate.now().toString());
                intent.putExtra("last_edit_date", LocalDate.now().toString());
                Context.startActivity(intent);
            }
        });

        parentView.addView(cardView);
    }

    public Card(android.content.Context context, String userMail, String platformName, boolean favoriteAccount) {
        UserMail = userMail;
        PlatformName = platformName;
        FavoriteAccount = favoriteAccount;
        Context = context;
    }
}



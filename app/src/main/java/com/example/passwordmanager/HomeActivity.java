package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private LinearLayout CardList;
    private ImageButton BackgroundButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        CardList = findViewById(R.id.card_list);
        BackgroundButton = findViewById(R.id.background_button);

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
        * TODO: add if-else to choose between different images of platform and have one default one if platform not found
        * Setting Image to avatarImage
        * */
        avatarImage.setImageResource(R.drawable.google_logo);
//        avatarImage.setMinimumWidth(255);
//        avatarImage.setMinimumHeight(114);
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
        parentView.addView(cardView);
    }

    public Card(Context context, String userMail, String platformName, boolean favoriteAccount) {
        UserMail = userMail;
        PlatformName = platformName;
        FavoriteAccount = favoriteAccount;
        Context = context;
    }
}
















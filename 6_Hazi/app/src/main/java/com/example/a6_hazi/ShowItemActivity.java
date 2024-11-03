package com.example.a6_hazi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int flagId = extras.getInt("flag", -1);
            String shortName = extras.getString("short_name", "");
            String fullName = extras.getString("name");
            String buyPrice = extras.getString("buy");
            String sellPrice = extras.getString("sell");

            Log.d("ShowItemActivity", "flagId: " + flagId);
            Log.d("ShowItemActivity", "shortName: " + shortName);
            Log.d("ShowItemActivity", "fullName: " + fullName);
            Log.d("ShowItemActivity", "buyPrice: " + buyPrice);
            Log.d("ShowItemActivity", "sellPrice: " + sellPrice);


            if (flagId != -1) {
                ImageView flagImageView = findViewById(R.id.flag_image);
                flagImageView.setImageResource(flagId);
            }

            TextView shortNameText = findViewById(R.id.short_name);
            TextView fullNameText = findViewById(R.id.full_name);
            TextView buyPriceText = findViewById(R.id.buy_price);
            TextView sellPriceText = findViewById(R.id.sell_price);

            shortNameText.setText(shortName);
            fullNameText.setText(fullName);
            buyPriceText.setText("Buy: " + buyPrice);
            sellPriceText.setText("Sell: " + sellPrice);
        }
    }
}
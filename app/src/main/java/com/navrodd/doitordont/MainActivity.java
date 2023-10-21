package com.navrodd.doitordont;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView btpressed,btunpressed;
    private AdView adView;
    TextView endgame;
    ArrayList<Integer> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        for(int i=0;i<13;i++){
            list.add(i);
        }

        Collections.shuffle(list);

        adView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        btunpressed = findViewById(R.id.imageView4);
        btpressed = findViewById(R.id.imageView5);
        btpressed.setVisibility(View.GONE);
        btunpressed.setVisibility(View.VISIBLE);
        btunpressed.setClickable(true);
        endgame = findViewById(R.id.textView2);
        endgame.setClickable(true);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        endgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), endCredits.class);
                startActivity(intent);
            }
        });

        btunpressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btunpressed.setVisibility(View.INVISIBLE);
                btpressed.setVisibility(View.VISIBLE);

                Random randomNum = new Random();

                int num = list.get(randomNum.nextInt(13));

                Intent intent = new Intent(getApplicationContext(), getAnswer.class);
                intent.putExtra("message",num);
                startActivity(intent);
            }
        });
    }
}
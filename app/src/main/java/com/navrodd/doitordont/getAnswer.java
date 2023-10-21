package com.navrodd.doitordont;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class getAnswer extends AppCompatActivity {

    TextView ori,one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,thirteen,darela;
    Button left,right;
    int result=0;
    ConstraintLayout constraintLayout;
    Random randomNum = new Random();
    ArrayList<Integer> list = new ArrayList<>();
    String[] choicw = {
            "Black",
            "White",
            "Black",
            "White"
    };
    String[] choicc = {
            "Heads",
            "Tails",
            "Heads",
            "Tails"
    };
    String[] choiclr = {
            "Do it",
            "Don't do it",
            "Don't do it",
            "Do it"
    };
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_answer);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        for(int i=0;i<4;i++){
            list.add(i);
        }

        Collections.shuffle(list);

        constraintLayout = findViewById(R.id.constraintLayout);
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this,"ca-app-pub-9428445034167893/9222067131", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i(TAG, loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });

        ori = findViewById(R.id.textView);
        one = findViewById(R.id.opt1);
        two = findViewById(R.id.opt2);
        three = findViewById(R.id.opt3);
        four = findViewById(R.id.opt4);
        five = findViewById(R.id.opt5);
        six = findViewById(R.id.opt6);
        seven = findViewById(R.id.opt7);
        eight = findViewById(R.id.opt8);
        nine = findViewById(R.id.opt9);
        ten = findViewById(R.id.opt10);
        eleven = findViewById(R.id.opt11);
        twelve = findViewById(R.id.opt12);
        thirteen = findViewById(R.id.opt13);
        left = findViewById(R.id.button);
        right = findViewById(R.id.button2);
        darela = findViewById(R.id.dare);

        ori.setVisibility(View.GONE);
        one.setVisibility(View.GONE);
        two.setVisibility(View.GONE);
        three.setVisibility(View.GONE);
        four.setVisibility(View.GONE);
        five.setVisibility(View.GONE);
        six.setVisibility(View.GONE);
        seven.setVisibility(View.GONE);
        eight.setVisibility(View.GONE);
        nine.setVisibility(View.GONE);
        ten.setVisibility(View.GONE);
        eleven.setVisibility(View.GONE);
        twelve.setVisibility(View.GONE);
        thirteen.setVisibility(View.GONE);
        left.setVisibility(View.GONE);
        right.setVisibility(View.GONE);
        darela.setVisibility(View.GONE);


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();
        result = intent.getIntExtra("message",0);

        if(result == 0){
            one.setVisibility(View.VISIBLE);
            constraintLayout.setBackgroundColor(Color.parseColor("#E94B3C"));
            darela.setVisibility(View.VISIBLE);
            darela.setTextColor(Color.parseColor("#2D2926"));
        }
        else if(result == 1){
            two.setVisibility(View.VISIBLE);
            constraintLayout.setBackgroundColor(Color.parseColor("#5F4B8B"));
            darela.setVisibility(View.VISIBLE);
            darela.setTextColor(Color.parseColor("#E69A8D"));

        }
        else if(result == 2){
            three.setVisibility(View.VISIBLE);
            constraintLayout.setBackgroundColor(Color.parseColor("#ADEFD1"));
            darela.setVisibility(View.VISIBLE);
            darela.setTextColor(Color.parseColor("#00203F"));

        }
        else if(result == 3){
            four.setVisibility(View.VISIBLE);
            darela.setTextColor(Color.parseColor("#F3E5F5"));

            constraintLayout.setBackgroundColor(Color.parseColor("#000000"));
            int num = list.get(randomNum.nextInt(4));
            four.postDelayed(new Runnable() {
                @Override
                public void run() {
                    four.setText(choicw[num]);
                    four.append(" it is.");
                    darela.setVisibility(View.VISIBLE);
                }
            }, 5000);
        }
        else if(result == 4){
            five.setVisibility(View.VISIBLE);
            darela.setTextColor(Color.parseColor("#949398"));

            constraintLayout.setBackgroundColor(Color.parseColor("#F4DF4E"));
            int num = list.get(randomNum.nextInt(4));
            five.postDelayed(new Runnable() {
                @Override
                public void run() {
                    five.setText(choicc[num]);
                    five.append(" it is.");
                    darela.setVisibility(View.VISIBLE);
                }
            }, 5000);
        }
        else if(result == 5){
            six.setVisibility(View.VISIBLE);
            darela.setTextColor(Color.parseColor("#ADEFD1"));

            constraintLayout.setBackgroundColor(Color.parseColor("#00203F"));

            six.postDelayed(new Runnable() {
                @Override
                public void run() {
                    six.setVisibility(View.GONE);
                    left.setVisibility(View.VISIBLE);
                    right.setVisibility(View.VISIBLE);
                    darela.setVisibility(View.VISIBLE);
                }
            }, 5000);
        }
        else if(result == 6){
            seven.setVisibility(View.VISIBLE);
            darela.setTextColor(Color.parseColor("#00539C"));
            darela.setVisibility(View.VISIBLE);
            constraintLayout.setBackgroundColor(Color.parseColor("#EEA47F"));
        }
        else if(result == 7){
            eight.setVisibility(View.VISIBLE);
            darela.setTextColor(Color.parseColor("#101820"));
            darela.setVisibility(View.VISIBLE);
            constraintLayout.setBackgroundColor(Color.parseColor("#FEE715"));
        }
        else if(result == 8){
            nine.setVisibility(View.VISIBLE);
            darela.setTextColor(Color.parseColor("#FEE715"));
            darela.setVisibility(View.VISIBLE);
            constraintLayout.setBackgroundColor(Color.parseColor("#101820"));
        }
        else if(result == 9){
            ten.setVisibility(View.VISIBLE);
            darela.setTextColor(Color.parseColor("#2C5F2D"));
            darela.setVisibility(View.VISIBLE);
            constraintLayout.setBackgroundColor(Color.parseColor("#97BC62"));
        }
        else if(result==10){
            eleven.setVisibility(View.VISIBLE);
            darela.setTextColor(Color.parseColor("#9CC3D5"));
            darela.setVisibility(View.VISIBLE);
            constraintLayout.setBackgroundColor(Color.parseColor("#0063B2"));
        }
        else if(result==11){
            twelve.setVisibility(View.VISIBLE);
            darela.setTextColor(Color.parseColor("#9CC3D5"));
            darela.setVisibility(View.VISIBLE);
            constraintLayout.setBackgroundColor(Color.parseColor("#0063B2"));
        }
        else if(result == 12){
            thirteen.setVisibility(View.VISIBLE);
            darela.setTextColor(Color.parseColor("#2BAE66"));
            darela.setVisibility(View.VISIBLE);
            constraintLayout.setBackgroundColor(Color.parseColor("#FCF6F5"));

        }

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = list.get(randomNum.nextInt(4));
                left.setText(choiclr[num]);
                left.setOnClickListener(null);
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = list.get(randomNum.nextInt(4));
                right.setText(choiclr[num]);
                right.setOnClickListener(null);
            }
        });
    }
    int counter = 0;
    @Override
    public void onBackPressed() {
        counter++;
        if(counter>=1) {

            if (mInterstitialAd != null) {
                mInterstitialAd.show(getAnswer.this);
                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        // Called when fullscreen content is dismissed.
                        Log.d("TAG", "The ad was dismissed.");
                        mInterstitialAd = null;
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        // Called when fullscreen content failed to show.
                        Log.d("TAG", "The ad failed to show.");
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        // Called when fullscreen content is shown.
                        // Make sure to set your reference to null so you don't
                        // show it a second time.
                        mInterstitialAd = null;
                        Log.d("TAG", "The ad was shown.");
                    }
                });
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }

        }

    }
}
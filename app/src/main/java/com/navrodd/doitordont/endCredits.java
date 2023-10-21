package com.navrodd.doitordont;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class endCredits extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_credits);
        text = findViewById(R.id.textView5);
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
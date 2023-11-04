package com.example.zhibekromanbekova_hw7_2m;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

       Intent intent = getIntent();
       int result = intent.getIntExtra("result",  0);

       resultView = findViewById(R.id.result_textView);
       resultView.setText(String.valueOf(result));
    }
}
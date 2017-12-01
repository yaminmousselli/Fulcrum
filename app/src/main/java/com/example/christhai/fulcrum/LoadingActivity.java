package com.example.christhai.fulcrum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.os.SystemClock.sleep;

public class LoadingActivity extends AppCompatActivity {
    private Score score = new Score();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        score.loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_loading);
        sleep(5000);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
    }
}

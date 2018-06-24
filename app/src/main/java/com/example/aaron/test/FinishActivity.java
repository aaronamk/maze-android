package com.example.aaron.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
    }
    public void switchToMenu(){
        Intent intent = new Intent(this, AMazeActivity.class);
        startActivity(intent);
    }
    public void onBackPressed() {
        startActivity(new Intent(this, AMazeActivity.class));
        return;
    }
}

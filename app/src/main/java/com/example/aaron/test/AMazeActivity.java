package com.example.aaron.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;

public class AMazeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amaze);
    }
    public void switchToGenerating(View view){
        Intent intent = new Intent(this, GeneratingActivity.class);
        startActivity(intent);
    }
}

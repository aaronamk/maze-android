package com.example.aaron.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PlayManuallyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_manually);
    }
    public void onBackPressed() {
        startActivity(new Intent(this, AMazeActivity.class));
        return;
    }
    public void switchToFinish(View view){
        Intent intent = new Intent(this, FinishActivity.class);
        intent.putExtra("path", "Manual");
        startActivity(intent);
    }
}

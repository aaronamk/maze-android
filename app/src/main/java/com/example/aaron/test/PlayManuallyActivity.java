package com.example.aaron.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.aaron.test.gui.MazePanel;
import com.example.aaron.test.gui.StatePlaying;

public class PlayManuallyActivity extends AppCompatActivity {
    private StatePlaying SP = new StatePlaying();
    private MazePanel MP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_manually);
        MP = findViewById(R.id.MazeView);
        SP.setMazeConfiguration(GeneratingActivity.MC);
        SP.start(MP);
    }
    public void onBackPressed() {
        startActivity(new Intent(this, AMazeActivity.class));
        finish();
        return;
    }
    public void switchToFinish(View view){
        Intent intent = new Intent(this, FinishActivity.class);
        intent.putExtra("path", "Manual");
        startActivity(intent);
        finish();
    }
}

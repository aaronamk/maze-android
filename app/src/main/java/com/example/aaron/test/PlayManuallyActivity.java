package com.example.aaron.test;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.aaron.test.gui.MazePanel;
import com.example.aaron.test.gui.StatePlaying;

public class PlayManuallyActivity extends AppCompatActivity {
    public static Bitmap B;
    private StatePlaying SP;
    private MazePanel MP;
    private Canvas C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        B = Bitmap.createBitmap(300,300,Bitmap.Config.ARGB_8888);
        SP = new StatePlaying();
        C = new Canvas(B);
        MP = new MazePanel(this);
        setContentView(R.layout.activity_play_manually);
        SP.setMazeConfiguration(GeneratingActivity.MC);
        MP.setCanvas(C);
        SP.start(MP);
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

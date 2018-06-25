package com.example.aaron.test;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class GeneratingActivity extends AppCompatActivity {
    private ProgressBar LoadBar;
    private int progress = 0;
    private Handler handler = new Handler();
    private boolean Manual = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generating);

        LoadBar = findViewById(R.id.load_bar);

        Intent intent = getIntent();
        if(intent.getStringExtra("mode").equals("Manual"))
            Manual = true;

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progress < 100){
                    progress++;
                    android.os.SystemClock.sleep(50);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            LoadBar.setProgress(progress);
                        }
                    });
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(Manual)
                            switchToManual();
                        else
                            switchToAnimation();
                    }
                });
            }
        }).start();
    }
    public void switchToTitle(View view){
        startActivity(new Intent(this, AMazeActivity.class));
    }

    public void switchToManual(){
        startActivity(new Intent(this, PlayManuallyActivity.class));
    }

    public void switchToAnimation(){
        startActivity(new Intent(this, PlayAnimationActivity.class));
    }
}

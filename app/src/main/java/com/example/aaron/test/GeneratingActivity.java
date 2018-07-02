package com.example.aaron.test;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.aaron.test.generation.MazeConfiguration;
import com.example.aaron.test.generation.MazeFactory;
import com.example.aaron.test.generation.Order;

public class GeneratingActivity extends AppCompatActivity implements Order {
    private ProgressBar LoadBar;
    private int Progress = 0;
    private Handler handler = new Handler();
    private int SkillLevel;
    Builder Builder;
    boolean Perfect;
    private boolean Manual = true;
    MazeFactory F;
    public static MazeConfiguration MC;

    public GeneratingActivity(){ }

    public GeneratingActivity(int SkillLevel, Builder Builder, boolean Perfect){
        this.SkillLevel = SkillLevel;
        this.Builder = Builder;
        this.Perfect = Perfect;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generating);
        F = new MazeFactory();
        this.SkillLevel = 2;
        this.Builder = Builder.Kruskal;
        this.Perfect = false;
        LoadBar = findViewById(R.id.load_bar);

        Intent intent = getIntent();
        F.order(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(Progress < 100){
                    Progress++;
                    android.os.SystemClock.sleep(50);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            LoadBar.setProgress(Progress);
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

    @Override
    public int getSkillLevel() {
        return SkillLevel;
    }

    @Override
    public Builder getBuilder() {
        return Builder;
    }

    @Override
    public boolean isPerfect() {
        return Perfect;
    }

    @Override
    public void deliver(MazeConfiguration mazeConfig) {
        startActivity(new Intent(this, PlayManuallyActivity.class));
        MC = mazeConfig;
    }
    public MazeConfiguration getMazeConfiguration() {
        return MC;
    }

    public void updateProgress(int percentage) {
        Progress = percentage;
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
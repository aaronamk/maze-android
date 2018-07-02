package com.example.aaron.test;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.aaron.test.generation.MazeConfiguration;
import com.example.aaron.test.generation.MazeFactory;
import com.example.aaron.test.generation.Order.Builder;
import com.example.aaron.test.generation.StubOrder;

public class GeneratingActivity extends AppCompatActivity {
    private ProgressBar LoadBar;
    private int Progress = 0;
    private Handler handler = new Handler();;
    private boolean Manual = false;
    MazeFactory F;
    StubOrder Order;
    public static MazeConfiguration MC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generating);
        F = new MazeFactory();
        Order = new StubOrder(2, Builder.Kruskal, false);
        MC = Order.getMazeConfiguration();
        LoadBar = findViewById(R.id.load_bar);

        Intent intent = getIntent();
        //if(intent.getStringExtra("mode").equals("Manual"))
            Manual = true;

        new Thread(new Runnable() {
            @Override
            public void run() {
                F.order(Order);
                while(Progress < 100){
                    Progress++;
                    android.os.SystemClock.sleep(500);
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
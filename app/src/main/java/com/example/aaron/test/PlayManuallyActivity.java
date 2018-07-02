package com.example.aaron.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.aaron.test.gui.Constants;
import com.example.aaron.test.gui.MazePanel;
import com.example.aaron.test.gui.StatePlaying;

public class PlayManuallyActivity extends AppCompatActivity {
    private StatePlaying SP = new StatePlaying();
    public static MazePanel MP;
    Switch ShowSolution, ShowMaze, ShowFullMap;
    Button Up, Down, Left, Right;
    final String TAG = "PlayManuallyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_manually);
        MP = findViewById(R.id.MazeView);
        SP.setMazeConfiguration(GeneratingActivity.MC);
        SP.start(MP);

        ShowSolution = findViewById(R.id.show_solution);
        ShowSolution.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SP.keyDown(Constants.UserInput.ToggleSolution, 0);
                Log.v(TAG, "TOGGLE SOLUTION");
            }
        });
        ShowMaze = findViewById(R.id.show_maze);
        ShowMaze.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SP.keyDown(Constants.UserInput.ToggleLocalMap, 0);
                Log.v(TAG, "LOCAL MAP");
            }
        });
        ShowFullMap = findViewById(R.id.show_full_map);
        ShowFullMap.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SP.keyDown(Constants.UserInput.ToggleFullMap, 0);
                Log.v(TAG, "FULL MAP");
            }
        });
        Up = findViewById(R.id.up_button);
        Up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SP.keyDown(Constants.UserInput.Up, 0);
                Log.v(TAG, "UP");
            }
        });
        Down = findViewById(R.id.down_button);
        Down.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SP.keyDown(Constants.UserInput.Down, 0);
                Log.v(TAG, "DOWN");
            }
        });
        Left = findViewById(R.id.left_button);
        Left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SP.keyDown(Constants.UserInput.Left, 0);
                Log.v(TAG, "LEFT");
            }
        });
        Right = findViewById(R.id.right_button);
        Right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SP.keyDown(Constants.UserInput.Right, 0);
                Log.v(TAG, "RIGHT");
            }
        });
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

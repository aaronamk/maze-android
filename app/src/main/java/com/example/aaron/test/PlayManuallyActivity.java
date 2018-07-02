package com.example.aaron.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.aaron.test.gui.Constants;
import com.example.aaron.test.gui.MazePanel;
import com.example.aaron.test.gui.StatePlaying;

public class PlayManuallyActivity extends AppCompatActivity {
    private StatePlaying SP = new StatePlaying();
    public static MazePanel MP;
    Switch ShowSolution, ShowMaze, ShowFullMap;

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
            }
        });
        ShowMaze = findViewById(R.id.show_maze);
        ShowMaze.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SP.keyDown(Constants.UserInput.ToggleLocalMap, 0);
            }
        });
        ShowFullMap = findViewById(R.id.show_full_map);
        ShowFullMap.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SP.keyDown(Constants.UserInput.ToggleFullMap, 0);
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

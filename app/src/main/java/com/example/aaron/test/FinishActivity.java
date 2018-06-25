package com.example.aaron.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {
    TextView PathLength;
    TextView EnergyConsumption;
    TextView WinLose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        PathLength = findViewById(R.id.path_length);
        PathLength.setText("");

        EnergyConsumption = findViewById(R.id.energy);
        EnergyConsumption.setText("");

        WinLose = findViewById(R.id.win_lose);
        WinLose.setText("");

        Intent intent = getIntent();
        if(intent.getStringExtra("path").equals("Manual")){
            WinLose.setText("You Made It!");
        }
        else if(intent.getStringExtra("path").equals("Win")){
            WinLose.setText("Smart Robot!");
            EnergyConsumption.setText("Energy Left: X");
            PathLength.setText("Length: Y");
        }
        else{
            WinLose.setText("Must be poorly coded....");
            EnergyConsumption.setText("Energy Left: 0");
            PathLength.setText("Length: X");
        }
    }
    public void onBackPressed() {
        startActivity(new Intent(this, AMazeActivity.class));
        return;
    }
}

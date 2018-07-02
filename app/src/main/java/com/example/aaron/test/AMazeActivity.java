package com.example.aaron.test;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class AMazeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] method = {"Manual", "Wall Follower", "Prim"};
    String robotselection;
    Spinner robot;

    String[] GenerationList = {"input.xml", "Prim", "Kruskal"};
    Spinner generation;
    SeekBar Size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amaze);

        robot = findViewById(R.id.select_robot);
        robot.setOnItemSelectedListener(this);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, method);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        robot.setAdapter(adapter);

        generation = findViewById(R.id.select_generation);
        generation.setOnItemSelectedListener(this);
        ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, GenerationList);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        generation.setAdapter(adapter2);

        Size=findViewById(R.id.size);
        Size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.v("AMazeActivity", "Bar Selected");
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.v("AMazeActivity", "Bar Released at value: "+Size.getProgress());
            }
        });
    }

    public void switchToGenerating(View view){
        Log.v(null, "Switched to generating,");
        Intent intent = new Intent(this, GeneratingActivity.class);
        intent.putExtra("mode", robotselection);
        intent.putExtra("size", Size.getProgress());
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.v("AMazeActivity", "Selection: " + generation.getSelectedItem());
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) { }
}

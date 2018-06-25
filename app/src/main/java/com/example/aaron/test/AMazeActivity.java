package com.example.aaron.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AMazeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] method = {"Manual", "Wall Follower", "Prim"};
    String robotselection;
    Spinner robot;

    String[] GenerationList = {"input.xml", "Prim", "Kruskal"};
    String GenerationSelection;
    Spinner generation;

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
    }

    public void switchToGenerating(View view){
        Intent intent = new Intent(this, GeneratingActivity.class);
        intent.putExtra("mode", robotselection);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        robotselection = method[position];
        Toast.makeText(getApplicationContext(), robotselection, Toast.LENGTH_SHORT).show();

        GenerationSelection = GenerationList[position];
        Toast.makeText(getApplicationContext(), GenerationSelection, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) { }
}

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
    String[] generation = {"Manual", "Prim", "Kruskal"};
    String Algorithm;
    Spinner Spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amaze);

        Spin = findViewById(R.id.select_generation_algorithm);
        Spin.setOnItemSelectedListener(this);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,generation);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spin.setAdapter(adapter);
    }

    public void switchToGenerating(View view){
        Intent intent = new Intent(this, GeneratingActivity.class);
        intent.putExtra("mode", Algorithm);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Algorithm = generation[position];
        Toast.makeText(getApplicationContext(), Algorithm, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

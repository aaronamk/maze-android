package com.example.aaron.test.generation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.aaron.test.PlayManuallyActivity;

public class StubOrder extends AppCompatActivity implements Order {
    private int SkillLevel;
    Builder Builder;
    boolean Perfect;
    int Progress = 0;
    MazeConfiguration MazeConfig = new MazeContainer();

    public StubOrder() {}

    public StubOrder(int SkillLevel, Builder Builder, boolean Perfect) {
        this.SkillLevel = SkillLevel;
        this.Builder = Builder;
        this.Perfect = Perfect;
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
        this.MazeConfig = mazeConfig;
    }

    @Override
    public void updateProgress(int percentage) {
        Progress = percentage;
    }

    public MazeConfiguration getMazeConfiguration() {
        return MazeConfig;
    }

    public int getProgress() {
        return Progress;
    }
}

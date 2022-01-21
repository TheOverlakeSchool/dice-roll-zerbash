package org.overlake.mat803.diceroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int mDieValue = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumberPicker picker = findViewById(R.id.picker);
        picker.setMinValue(1);
        picker.setMaxValue(6);
        picker.setWrapSelectorWheel(false);
        picker.setOnValueChangedListener((picker1, oldVal, newVal) -> {
            mDieValue = newVal;
        });
        findViewById(R.id.roll).setOnClickListener(v -> {
            roll();
        });
    }

    private void roll() {
        Random random = new Random();
        int value = random.nextInt(mDieValue) + 1;
        ((TextView) findViewById(R.id.result)).setText(String.valueOf(value));
    }
}
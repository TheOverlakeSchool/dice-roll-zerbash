package org.overlake.mat803.diceroll;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String DIE_VALUE = "die_value";
    private static final String ROLL_RESULT = "roll_result";
    private int mDieValue = 1;
    private final Random mRandom = new Random();
    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPicker();
        findViewById(R.id.roll).setOnClickListener(v -> {
            roll();
        });
        mResult = findViewById(R.id.result);
    }

    private void initPicker() {
        NumberPicker picker = findViewById(R.id.picker);
        picker.setMinValue(1);
        picker.setMaxValue(6);
        picker.setWrapSelectorWheel(false);
        picker.setOnValueChangedListener((picker1, oldVal, newVal) -> {
            mDieValue = newVal;
        });
    }

    private void roll() {
        int value = mRandom.nextInt(mDieValue) + 1;
        mResult.setText(String.valueOf(value));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(DIE_VALUE, mDieValue);
        outState.putCharSequence(ROLL_RESULT, mResult.getText());
    }
}
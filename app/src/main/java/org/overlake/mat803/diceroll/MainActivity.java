package org.overlake.mat803.diceroll;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String DIE_VALUE = "die_value";
    private static final String ROLL_RESULT = "roll_result";
    private int mDieValue = 1;
    private final Random mRandom = new Random();
    private ImageView mResult;
    private int[] mDiceImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.roll).setOnClickListener(v -> {
            roll();
        });
        mResult = findViewById(R.id.result);
        if (savedInstanceState != null) {
            mDieValue = savedInstanceState.getInt(DIE_VALUE);
      //      mResult.setText(savedInstanceState.getCharSequence(ROLL_RESULT));
        }
        initPicker();
        mDiceImages = new int[] {
                R.drawable.dice_1,
                R.drawable.dice_2,
                R.drawable.dice_3,
                R.drawable.dice_4,
                R.drawable.dice_5,
                R.drawable.dice_6
        };
    }

    private void initPicker() {
        NumberPicker picker = findViewById(R.id.picker);
        picker.setMinValue(1);
        picker.setMaxValue(6);
        picker.setValue(mDieValue);
        picker.setWrapSelectorWheel(false);
        picker.setOnValueChangedListener((picker1, oldVal, newVal) -> {
            mDieValue = newVal;
        });
    }

    private void roll() {
        int value = mRandom.nextInt(mDieValue);
        mResult.setImageResource(mDiceImages[value]);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(DIE_VALUE, mDieValue);
        outState.putString(ROLL_RESULT, mResult.getDrawable().toString());
    }
}
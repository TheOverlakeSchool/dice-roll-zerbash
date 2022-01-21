package org.overlake.mat803.diceroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumberPicker picker = findViewById(R.id.picker);
        picker.setMinValue(1);
        picker.setMaxValue(6);
        picker.setWrapSelectorWheel(false);
    }
}
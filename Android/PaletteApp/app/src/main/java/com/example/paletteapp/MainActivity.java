package com.example.paletteapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    private int currentProgress = 0;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        TextView textView = findViewById(R.id.textColor);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButton){
                    textView.setTextColor(Color.parseColor("#009212"));
                } else if (checkedId == R.id.radioButton2) {
                    textView.setTextColor(Color.parseColor("#FF6F00"));
                }
            }
        });

        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        Button chooseColor = findViewById(R.id.changeColor);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton.isChecked()){
                    chooseColor.setBackgroundColor(Color.parseColor("#009212"));
                } else{
                    chooseColor.setBackgroundColor(Color.parseColor("#FF6F00"));
                }
            }
        });

        Switch mySwitch = findViewById(R.id.switch1);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mySwitch.setTextColor(Color.parseColor("#FF6F00"));
                } else{
                    mySwitch.setTextColor(Color.parseColor("#009212"));
                }
            }
        });

        ConstraintLayout constraintLayout = findViewById(R.id.main);
        SwitchMaterial switchMaterial = findViewById(R.id.switch2);
        switchMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchMaterial.isChecked()){
                    switchMaterial.setText("Turn on Night mode");
                    switchMaterial.setThumbDrawable(getDrawable(R.drawable.outline_3d_rotation_24));
                    switchMaterial.setThumbTintList(ColorStateList.valueOf(Color.BLUE));
                    switchMaterial.setTrackTintList(ColorStateList.valueOf(Color.parseColor("#004CFF")));
                    constraintLayout.setBackgroundResource(R.color.bg);
                } else{
                    switchMaterial.setText("Turn on Light mode");
                    switchMaterial.setThumbDrawable(getDrawable(R.drawable.baseline_wb_sunny_24));
//                    switchMaterial.setThumbTintList(ColorStateList.valueOf(Color.GRAY));
                    switchMaterial.setTrackTintList(ColorStateList.valueOf(Color.parseColor("#FF6F00")));
                    constraintLayout.setBackgroundResource(R.color.yellow);
                }
            }
        });

        TextView sampleTextView = findViewById(R.id.sampleTextView);
        CheckBox boldCheckBox = findViewById(R.id.boldCheckBox);
        CheckBox italicCheckBox = findViewById(R.id.italicCheckBox);

        boldCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if(italicCheckBox.isChecked()){
                        sampleTextView.setTypeface(null, Typeface.BOLD_ITALIC);
                    } else {
                        sampleTextView.setTypeface(null, Typeface.BOLD);
                    }
                } else {
                    if(italicCheckBox.isChecked()){
                        sampleTextView.setTypeface(null, Typeface.ITALIC);
                    } else {
                        sampleTextView.setTypeface(null, Typeface.NORMAL);
                    }
                }
            }
        });

        italicCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if(boldCheckBox.isChecked()){
                        sampleTextView.setTypeface(null, Typeface.BOLD_ITALIC);
                    } else {
                        sampleTextView.setTypeface(null, Typeface.ITALIC);
                    }
                } else {
                    if(boldCheckBox.isChecked()){
                        sampleTextView.setTypeface(null, Typeface.BOLD);
                    } else {
                        sampleTextView.setTypeface(null, Typeface.NORMAL);
                    }
                }
            }
        });

        Button buttonForProgress = findViewById(R.id.button2);
        buttonForProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressBar pb = findViewById(R.id.progressBar);
                pb.setVisibility(View.VISIBLE);
            }
        });

        progressBar = findViewById(R.id.progressBarHorizontal);
        Button startProgress = findViewById(R.id.startProgress);

        startProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentProgress = currentProgress + 10;
                progressBar.setProgress(currentProgress);
                progressBar.setMax(100);
            }
        });

        Chip chip = findViewById(R.id.chip);
        chip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Action Completed", Toast.LENGTH_SHORT).show();
            }
        });

//        Button chooseColor = findViewById(R.id.changeColor);
//
//        chooseColor.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                RadioGroup radioGroup = findViewById(R.id.radioGroup);
//                int checkButtonIndex = radioGroup.getCheckedRadioButtonId();
//                TextView textView = findViewById(R.id.textColor);
//
//                if(checkButtonIndex == R.id.radioButton){
//                    textView.setTextColor(Color.parseColor("#009212"));
//                } else {
//                    textView.setTextColor(Color.parseColor("#FF6F00"));
//                }
//            }
//        });

    }
}
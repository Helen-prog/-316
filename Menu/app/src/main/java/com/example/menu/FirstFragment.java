package com.example.menu;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class FirstFragment extends Fragment {

    RatingBar ratingBar;
    Button ratingButton;

    Spinner spinnerColors;
    Button buttonFindDescription;
    TextView textViewDescription;
    
    SeekBar seekBar;
    TextView textView;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        ratingBar = view.findViewById(R.id.ratingBar);
        ratingButton = view.findViewById(R.id.ratingsBtn);

        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float value = ratingBar.getRating();
                Toast.makeText(getContext(), "Rating: " + value, Toast.LENGTH_SHORT).show();
            }
        });

        spinnerColors = view.findViewById(R.id.spinner);
        buttonFindDescription = view.findViewById(R.id.buttonFindDescription);
        textViewDescription = view.findViewById(R.id.textViewDescription);

        buttonFindDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = spinnerColors.getSelectedItemPosition();
                String description = getDescriptionPosition(position);
                textViewDescription.setText(description);
            }
        });
        
        seekBar = view.findViewById(R.id.seekBar);
        textView = view.findViewById(R.id.textView2);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText(progress + "/100");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textView.setTextColor(Color.parseColor("#FF6100"));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setTextColor(Color.parseColor("gray"));
            }
        });


        return view;
    }

    private String getDescriptionPosition(int position) {
        String[] description = getResources().getStringArray(R.array.description_of_temp);
        return description[position];
    }
}
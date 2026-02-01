package com.example.intentproject;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        Button button = findViewById(R.id.button2);
//        ImageView image = findViewById(R.id.boy_image);

//        image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((AnimationDrawable) image.getDrawable()).start();
////                Animation out = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.anim_alpha);
////                Animation out = AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim_alpha);
////                image.startAnimation(out);
//                Animation translate = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.anim_translate);
//                image.startAnimation(translate);
//            }
//        });
//
        ImageView image1 = findViewById(R.id.boy_img_0);
        ImageView image2 = findViewById(R.id.boy_img_1);

        Button buttonRotateCenter = findViewById(R.id.rotate_center);
        Button buttonRotateCorner = findViewById(R.id.rotate_corner);

        Animation animationRotateCenter = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.rotete_center);
        Animation animationRotateCorner = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.rotate_corners);

        buttonRotateCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image1.startAnimation(animationRotateCenter);
            }
        });

        buttonRotateCorner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image2.startAnimation(animationRotateCorner);
            }
        });

        Animation shrink = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.shrink);
        buttonRotateCenter.startAnimation(shrink);




//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
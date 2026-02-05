package com.example.gamesample;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Level1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        final ImageView imgLeft = findViewById(R.id.img_left);
        final ImageView imgRight = findViewById(R.id.img_right);

        imgLeft.setClipToOutline(true);
        imgRight.setClipToOutline(true);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
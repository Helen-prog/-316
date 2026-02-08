package com.example.gamesample;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Random;

public class Level2 extends AppCompatActivity {

    Dialog dialog;

    public int numLeft, numRight;
    Array array = new Array();
    Random random = new Random();
    public int count = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        TextView textLevels = findViewById(R.id.text_levels);
        textLevels.setText(R.string.level_1);

        final ImageView imgLeft = findViewById(R.id.img_left);
        final ImageView imgRight = findViewById(R.id.img_right);

        imgLeft.setClipToOutline(true);
        imgRight.setClipToOutline(true);

        final TextView textLeft = findViewById(R.id.text_left);
        final TextView textRight = findViewById(R.id.text_right);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.preview_dialog);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setCancelable(false);

        ImageView previewImg = dialog.findViewById(R.id.imageView2);
        previewImg.setImageResource(R.drawable.number_lev_two);

        TextView textDescription = dialog.findViewById(R.id.text_description);
        textDescription.setText(R.string.level_two);

        TextView buttonClose = dialog.findViewById(R.id.button_close);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level2.this, GameActivity.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });

        Button buttonContinue = dialog.findViewById(R.id.button_continue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

        Button buttonBack = findViewById(R.id.button_back_level);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level2.this, GameActivity.class);
                startActivity(intent);
            }
        });

        final Animation animation = AnimationUtils.loadAnimation(Level2.this, R.anim.alpha);

        numLeft = random.nextInt(10);
        imgLeft.setImageResource(array.images2[numLeft]);
        textLeft.setText(array.text2[numLeft]);

        numRight = random.nextInt(10);
        while (numLeft == numRight) {
            numRight = random.nextInt(10);
        }
        imgRight.setImageResource(array.images2[numRight]);
        textRight.setText(array.text2[numRight]);

        final int[] progress = {R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10, R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15, R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20};

        imgLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    imgRight.setEnabled(false);
                    if (numLeft > numRight) {
                        imgLeft.setImageResource(R.drawable.img_true);
                    } else {
                        imgLeft.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    // если отпустили палец
                    if (numLeft > numRight) {
                        if (count < 20) {
                            count++;
                        }
                        for (int j : progress) {
                            TextView tv = findViewById(j);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    } else {
                        // если левая картинка будет меньше
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count -= 2;
                            }
                        }
                        for (int i = 0; i < progress.length - 1; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    if (count == 20) {
                        // выход из уровня
                    } else {
                        numLeft = random.nextInt(10);
                        imgLeft.setImageResource(array.images2[numLeft]);
                        imgLeft.startAnimation(animation);
                        textLeft.setText(array.text2[numLeft]);

                        numRight = random.nextInt(10);
                        while (numLeft == numRight) {
                            numRight = random.nextInt(10);
                        }
                        imgRight.setImageResource(array.images2[numRight]);
                        imgRight.startAnimation(animation);
                        textRight.setText(array.text2[numRight]);
                        imgRight.setEnabled(true);
                    }

                }
                return true;
            }
        });

        imgRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    imgLeft.setEnabled(false);
                    if (numLeft < numRight) {
                        imgRight.setImageResource(R.drawable.img_true);
                    } else {
                        imgRight.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    // если отпустили палец
                    if (numLeft < numRight) {
                        if (count < 20) {
                            count++;
                        }
                        for (int j : progress) {
                            TextView tv = findViewById(j);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    } else {
                        // если левая картинка будет меньше
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count -= 2;
                            }
                        }
                        for (int i = 0; i < progress.length - 1; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    if (count == 20) {
                        // выход из уровня
                    } else {
                        numLeft = random.nextInt(10);
                        imgLeft.setImageResource(array.images2[numLeft]);
                        imgLeft.startAnimation(animation);
                        textLeft.setText(array.text2[numLeft]);

                        numRight = random.nextInt(10);
                        while (numLeft == numRight) {
                            numRight = random.nextInt(10);
                        }
                        imgRight.setImageResource(array.images2[numRight]);
                        imgRight.startAnimation(animation);
                        textRight.setText(array.text2[numRight]);
                        imgLeft.setEnabled(true);
                    }

                }
                return true;
            }
        });
    }
}
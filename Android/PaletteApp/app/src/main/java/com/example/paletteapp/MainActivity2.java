package com.example.paletteapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    EditText editTextName, editTextEmail;
    Button buttonSave;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSave = findViewById(R.id.buttonSava);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME, null);
        if(name != null){
            Intent intent = new Intent(MainActivity2.this, HomeActivity.class);
            startActivity(intent);
        }

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, editTextName.getText().toString());
                editor.putString(KEY_EMAIL, editTextEmail.getText().toString());
                editor.apply();
                Intent intent = new Intent(MainActivity2.this, HomeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity2.this, "Login Success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
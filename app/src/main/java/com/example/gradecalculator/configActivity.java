package com.example.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class configActivity extends AppCompatActivity {

    private ConstraintLayout configLayout;
    private Button blueBtn;
    private Button whiteBtn;
    private Button blackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        configLayout= findViewById(R.id.configLayout);
        blueBtn= findViewById(R.id.blueBtn);
        whiteBtn= findViewById(R.id.whiteBtn);
        blackBtn= findViewById(R.id.blackBtn);

       SharedPreferences sp= getSharedPreferences("grades_app_bg_colors", MODE_PRIVATE);

        blueBtn.setOnClickListener(
                (v)->{
                    sp.edit().putString("color", "#03A9F4").apply();
                    finish();
                }
        );

        whiteBtn.setOnClickListener(
                (v)->{
                    sp.edit().putString("color", "#FFFFFFFF").apply();
                    finish();
                }
        );

        blackBtn.setOnClickListener(
                (v)->{
                    sp.edit().putString("color", "#4c4c4c").apply();
                    finish();
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp= getSharedPreferences("grades_app_bg_colors", MODE_PRIVATE);
        String bg= sp.getString("color", "#FFFFFFFF");
        configLayout.setBackgroundColor(Color.parseColor(bg));
    }


}
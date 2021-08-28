package com.example.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private ConstraintLayout nameLayout;
    private Button configBtn;
    private EditText editTxtName;
    private Button continueBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameLayout= findViewById(R.id.nameLayout);
        configBtn= findViewById(R.id.configBtn);
        editTxtName= findViewById(R.id.editTxtName);
        continueBtn= findViewById(R.id.continueBtn);


        configBtn.setOnClickListener(
                (v)->{
                    Intent i= new Intent(this, configActivity.class);
                    startActivity(i);
                }
        );

        continueBtn.setOnClickListener(
                (v)->{
                    Intent i= new Intent(this, grades_collect.class);
                    i.putExtra("name",editTxtName.getText().toString());
                    editTxtName.setText("");
                    startActivity(i);
                }
        );




    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp= getSharedPreferences("grades_app_bg_colors", MODE_PRIVATE);
        String bg= sp.getString("color", "#FFFFFFFF");
        nameLayout.setBackgroundColor(Color.parseColor(bg));
    }
}
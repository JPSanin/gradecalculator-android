package com.example.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class grades_collect extends AppCompatActivity {


    private ConstraintLayout collectLayout;
    private EditText editTextProject1;
    private EditText editTextProject2;
    private EditText editTextQuizzes;
    private EditText editTextExam1;
    private EditText editTextExam2;

    private Button btnCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades_collect);

        collectLayout= findViewById(R.id.collectLayout);
        editTextProject1= findViewById(R.id.editTextProject1);
        editTextProject2= findViewById(R.id.editTextProject2);
        editTextQuizzes= findViewById(R.id.editTextQuizzes);
        editTextExam1= findViewById(R.id.editTextExam1);
        editTextExam2= findViewById(R.id.editTextExam2);
        btnCalculate= findViewById(R.id.btnCalculate);

        String name= getIntent().getExtras().getString("name");

        btnCalculate.setOnClickListener(
                (v)->{

                    Intent i= new Intent(this, calculate_grades.class);
                    i.putExtra("name",name);

                    i.putExtra("project1",editTextProject1.getText().toString());
                    editTextProject1.setText("");

                    i.putExtra("project2",editTextProject2.getText().toString());
                    editTextProject2.setText("");

                    i.putExtra("quizzes",editTextQuizzes.getText().toString());
                    editTextQuizzes.setText("");

                    i.putExtra("exam1",editTextExam1.getText().toString());
                    editTextExam1.setText("");

                    i.putExtra("exam2",editTextExam2.getText().toString());
                    editTextExam2.setText("");

                    startActivity(i);
                    finish();
                }
        );



    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp= getSharedPreferences("grades_app_bg_colors", MODE_PRIVATE);
        String bg= sp.getString("color", "#FFFFFFFF");
        collectLayout.setBackgroundColor(Color.parseColor(bg));
    }
}
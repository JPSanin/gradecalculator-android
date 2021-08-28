package com.example.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class calculate_grades extends AppCompatActivity {

    private ConstraintLayout calculateLayout;
    private TextView txtNameMessage;
    private TextView txtGrade;
    private Button btnCalculateAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_grades);

        calculateLayout= findViewById(R.id.calculateLayout);
        txtNameMessage= findViewById(R.id.txtNameMessage);
        txtGrade= findViewById(R.id.txtGrade);
        btnCalculateAgain= findViewById(R.id.btnCalculateAgain);

        loadScreen();

        btnCalculateAgain.setOnClickListener(
                (v)->{

                    finish();
                }
        );

    }


    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp= getSharedPreferences("grades_app_bg_colors", MODE_PRIVATE);
        String bg= sp.getString("color", "#FFFFFFFF");
        calculateLayout.setBackgroundColor(Color.parseColor(bg));
    }

    public void loadScreen(){
        String name= getIntent().getExtras().getString("name");
        txtNameMessage.setText("Hola, "+ name + ". \nTu nota final es de:");
        String grade1= getIntent().getExtras().getString("project1");
        String grade2= getIntent().getExtras().getString("project2");
        String grade3= getIntent().getExtras().getString("quizzes");
        String grade4= getIntent().getExtras().getString("exam1");
        String grade5= getIntent().getExtras().getString("exam2");

        double[] grades= new double[5];
        if(!grade1.isEmpty()){
            grades[0]= Double.parseDouble(grade1);
        }
        if(!grade2.isEmpty()){
            grades[1]= Double.parseDouble(grade2);
        }
        if(!grade3.isEmpty()){
            grades[2]= Double.parseDouble(grade3);
        }
        if(!grade4.isEmpty()){
            grades[3]= Double.parseDouble(grade4);
        }
        if(!grade5.isEmpty()){
            grades[4]= Double.parseDouble(grade5);
        }

        double finalGrade=0.0;

        finalGrade= ((grades[0]*0.15)+(grades[1]*0.15)+(grades[2]*0.15)+(grades[3]*0.25)+(grades[4]*0.30));

        txtGrade.setText(""+finalGrade);

        //Toast.makeText( this,""+grades[0], Toast.LENGTH_SHORT).show();

    }
}
package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class WonActivity extends AppCompatActivity {
        CircularProgressBar circularProgressBar;
        TextView resulttext;
        int correct,wrong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        correct=getIntent().getIntExtra("correct",0);
        wrong=getIntent().getIntExtra("wrong",0);

        circularProgressBar=findViewById(R.id.circularProgressBar);
        resulttext=findViewById(R.id.resulttext);
        circularProgressBar.setProgress(correct);
        resulttext.setText(correct+"/10");


    }
}
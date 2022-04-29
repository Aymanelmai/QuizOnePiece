package com.example.quizz;

import static com.example.quizz.Start.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Question extends AppCompatActivity {

    List<QuestionList> allQuestionslist;
    QuestionList questionList;
    int index=0;
    TextView card_question,option1,option2,option3,option4;
    CardView cardo1,cardo2,cardo3,cardo4;
    int correctCount=0;
    int wrongCount=0;
    LinearLayout nextbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        Hooks();
        allQuestionslist=list;
        Collections.shuffle(allQuestionslist);
        questionList=list.get(index);

        cardo1.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardo2.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardo3.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardo4.setCardBackgroundColor(getResources().getColor(R.color.white));

        nextbtn.setClickable(false);
        setAllData();

    }

    private void setAllData() {
        card_question.setText(questionList.getQuestion());
        option1.setText(questionList.getQ1());
        option2.setText(questionList.getQ2());
        option3.setText(questionList.getQ3());
        option4.setText(questionList.getQ4());

    }

    private void Hooks() {
        card_question=findViewById(R.id.card);
        option1=findViewById(R.id.card_option1);
        option2=findViewById(R.id.card_option2);
        option3=findViewById(R.id.card_option3);
        option4=findViewById(R.id.card_option4);
        cardo1=findViewById(R.id.card1);
        cardo2=findViewById(R.id.card2);
        cardo3=findViewById(R.id.card3);
        cardo4=findViewById(R.id.card4);
        nextbtn=findViewById(R.id.nextbtn);






    }

    public void correct(CardView cardView){
        cardView.setCardBackgroundColor(getResources().getColor(R.color.green));

    nextbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            correctCount++;
            index++;
            questionList=list.get(index);
            resetColor();
            setAllData();
            enableButton();

        }
    });


    }

    public void wrong(CardView card1){
        card1.setCardBackgroundColor(getResources().getColor(R.color.red));
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrongCount++;
                if(index<list.size()-1)
                {
                    index++;
                    questionList=list.get(index);
                    setAllData();
                    resetColor();
                    enableButton();

                }else{
                    GameWon();
                }
            }
        });



    }

    private void GameWon() {
        Intent intent=new Intent(Question.this,WonActivity.class);
        intent.putExtra("correct",correctCount);
        intent.putExtra("wrong",wrongCount);
        startActivity(intent);
    }

    public void enableButton()
    {
        cardo1.setClickable(true);
        cardo2.setClickable(true);
        cardo3.setClickable(true);
        cardo4.setClickable(true);

    }

    public void disableButton()
    {
        cardo1.setClickable(false);
        cardo2.setClickable(false);
        cardo3.setClickable(false);
        cardo4.setClickable(false);

    }

    public void resetColor(){

        cardo1.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardo2.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardo3.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardo4.setCardBackgroundColor(getResources().getColor(R.color.white));

    }

    public void Option1click(View view) {
        disableButton();
        nextbtn.setClickable(true);

        if(questionList.getQ1().equals(questionList.getCorrectanswer()))
        {
            cardo1.setCardBackgroundColor(getResources().getColor(R.color.green));

                if(index<list.size()-1)
                {
                    correct(cardo1);
                }
                else {
                    GameWon();
                }
        }else{
            wrong(cardo1);
        }
    }


    public void Option2click(View view) {
        disableButton();
        nextbtn.setClickable(true);
        if(questionList.getQ2().equals(questionList.getCorrectanswer()))
        {
            cardo2.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<list.size()-1)
            {
                correct(cardo2);
            }
            else {
                GameWon();
            }
        }else{
            wrong(cardo2);
        }
    }

    public void Option3click(View view) {
        disableButton();
        nextbtn.setClickable(true);
        if(questionList.getQ3().equals(questionList.getCorrectanswer()))
        {
            cardo3.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<list.size()-1)
            {
                correct(cardo3);
            }
            else {
                GameWon();
            }
        }else{
            wrong(cardo3);
        }
    }

    public void Option4click(View view) {
        disableButton();
        nextbtn.setClickable(true);
        if(questionList.getQ4().equals(questionList.getCorrectanswer()))
        {
            cardo4.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<list.size()-1)
            {

                correct(cardo4);
            }
            else {
                GameWon();
            }
        }else{
            wrong(cardo4);
        }
    }
}

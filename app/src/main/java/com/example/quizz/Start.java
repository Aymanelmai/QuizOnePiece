package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Start extends AppCompatActivity {

     public static ArrayList<QuestionList> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button startbtn=(Button) findViewById(R.id.startbtn);




        list = new ArrayList<>();
        list.add(new QuestionList("How many different full-length swords has Zoro canonically wielded as of chapter 1,000?","9","10","11","12","10"));
        list.add(new QuestionList("Which of the following arcs are anime-only filler?","The Long Ring Long Land arc","The G-8 Marine Base arc","Reverie","Marineford","The Long Ring Long Land arc"));
        list.add(new QuestionList("Which is not an attack Luffy has used at some point in the manga?","Gum Gum Pistol","Gum Gum Missile","Gum Gum Shotgun","Gum Gum Slingshot","Gum Gum Slingshot"));
        list.add(new QuestionList("Which is the correct ordering of the Straw Hats’ bounties from highest to lowest as of the Wano arc?","Luffy, Zoro, Sanji, Robin, Usopp.","Luffy, Jimbei, Usopp, Robin, Nami","Zoro, Usopp, Sanji, Franky, Robin","Usopp, Brook, Robin, Nami, Chopper","Luffy, Jimbei, Usopp, Robin, Nami"));
        list.add(new QuestionList("Which of these characters was or is a member of the Marines?","Sengoku.","X Drake.","Donquixote Rosinante","All of the above","All of the above"));
        list.add(new QuestionList("How many times was Whitebeard shot with bullets during the Paramount War arc?","72","49","152","256","152"));
        list.add(new QuestionList("How did Jaguar D. Saul, the giant Robin met as a child, laugh?","Dere Shi Shi Shi!","Ze Ha Ha Ha!","Wa Ha Ha Ha!","Gu Fu Fu Fu!","Dere Shi Shi Shi!"));
        list.add(new QuestionList("What Sea does Sanji originally come from?","North Blue","South Blue","East Blue","West Blue","North Blue"));
        list.add(new QuestionList("How many years passed between Brook’s crew being wiped out and his joining the Straw Hat Pirates?","100 Years","70 Years","60 Years","50 Years","50 Years"));
        list.add(new QuestionList("Following the time skip, which Straw Hat was the first to reach the Thousand Sunny?","Zoro","Robin","Chopper","Franky","Franky"));


        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(Start.this,Question.class);
                        startActivity(i);
                        finish();
                    }
                }, 2000);
            }
        });





    }
}
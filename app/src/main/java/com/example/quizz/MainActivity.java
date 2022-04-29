package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Username=(TextView) findViewById(R.id.Username);
        TextView Password=(TextView) findViewById(R.id.Password);
        Button loginbtn=(Button) findViewById(R.id.loginbtn);



        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Username.getText().toString().isEmpty() && Password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Username or Password are empty", Toast.LENGTH_SHORT).show();
                }
                    else{
                        Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                                Intent i = new Intent(MainActivity.this,Start.class);
                                startActivity(i);
                            finish();
                        }
                    }, 2000);





                }


            }
        });






    };
}
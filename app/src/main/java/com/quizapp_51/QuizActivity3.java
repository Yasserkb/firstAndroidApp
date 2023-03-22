package com.quizapp_51;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizActivity3 extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    Button bNext;
    int score;
    String RepCorrect="Non";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        rg=(RadioGroup) findViewById(R.id.rg);
        bNext=(Button) findViewById(R.id.bNext);
        Intent intent=getIntent();
        score=intent.getIntExtra("score",0) ;

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb=(RadioButton) findViewById(rg.getCheckedRadioButtonId());
                if(rg.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(),"Merci de choisir une réponse S.V.P !",Toast.LENGTH_SHORT).show();
                }
                else {

                    if(rb.getText().toString().equals(RepCorrect)){
                        score+=1;

                    }
                    Intent intent=new Intent(QuizActivity3.this,QuizActivity4.class);
                    intent.putExtra("score",score);
                    startActivity(intent);

                    overridePendingTransition(R.anim.exit,R.anim.entry);
                    finish();
                }

            }
        });


    }
}
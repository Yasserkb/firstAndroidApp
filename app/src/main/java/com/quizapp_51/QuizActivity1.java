package com.quizapp_51;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizActivity1 extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    Button bNext;
    int score = 0;
    String RepCorrect="Non";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        rg = (RadioGroup) findViewById(R.id.rg);
        bNext = (Button) findViewById(R.id.bNext);
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rg.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(), "Merci de choisir une reponse S.V.P", Toast.LENGTH_SHORT).show();
                }else{
                    rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                    if(rb.getText().toString().equals(RepCorrect)) {
                        score += 1;
                    }
                    Intent intent=new Intent(QuizActivity1.this,QuizActivity2.class);
                    intent.putExtra("score",score);
                    startActivity(intent);
                    overridePendingTransition(R.anim.exit,R.anim.entry);
                    finish();


                }
            }
        });
    }
}
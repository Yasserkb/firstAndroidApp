package com.quizapp_51;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText regLogin,regPassword,regConfPassword;
    Button regSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regLogin = (EditText) findViewById(R.id.regLogin);
        regPassword = (EditText) findViewById(R.id.regPassword);
        regConfPassword = (EditText) findViewById(R.id.regConfPassword);
        regSignUp = (Button) findViewById(R.id.regSignUp);

        regSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = regLogin.getText().toString();
                String password = regPassword.getText().toString();
                String passwordConf = regConfPassword.getText().toString();

                if (TextUtils.isEmpty(mail)){
                    Toast.makeText(getApplicationContext(), "Please fill in the required fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "Please fill in the required fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passwordConf)){
                    Toast.makeText(getApplicationContext(), "Please fill in the required fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length()<6){
                    Toast.makeText(getApplicationContext(), "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.equals(passwordConf)){
                    Toast.makeText(getApplicationContext(), "Please enter correct password", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getApplicationContext(), "Registration Successful !", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}
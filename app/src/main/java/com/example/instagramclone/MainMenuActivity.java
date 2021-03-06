package com.example.instagramclone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.parse.ParseUser;

public class MainMenuActivity extends AppCompatActivity{
    private static Context context;
    private Button btnSignUp;
    private Button btnGoToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnGoToLogin = findViewById(R.id.btnGoToLogin);
        btnSignUp = findViewById(R.id.btnSignup);

        //declare context
        MainMenuActivity.context = getApplicationContext();

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            Intent i = new Intent(context, MainActivity.class);
            startActivity(i);
        }

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, CreateAccountActivity.class);
                startActivity(i);
            }
        });

        btnGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, LoginActivity.class);
                startActivity(i);
            }
        });
    }

}

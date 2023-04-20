package com.example.health_north_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateAccountActivity extends AppCompatActivity {

    private TextView errorCreateAccountTextView;
    private EditText usernameEditText;
    private EditText passwordEditText;

    private Button createAccountBtn;
    private TextView alreadyHasAccountBtn;

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        alreadyHasAccountBtn = findViewById(R.id.alreadyHasAccountBtn);
        createAccountBtn = findViewById(R.id.createAccountBtn);
        usernameEditText = findViewById(R.id.createUsernameEditText);
        passwordEditText = findViewById(R.id.createPasswordEditText);
        errorCreateAccountTextView = findViewById(R.id.errorCreateAccountTextView);

        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = usernameEditText.getText().toString();
                password = passwordEditText.getText().toString();

                // Faire la requete pour créer l'utilisateur
            }
        });

        alreadyHasAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent connectToAccountActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(connectToAccountActivity);
            }
        });

    }
}
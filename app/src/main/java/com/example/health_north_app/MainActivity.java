package com.example.health_north_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.health_north_app.R;
import com.example.health_north_app.controleur.Control;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView errorConnectAccountTextView;

    private Control controle;
    private EditText usernameEditText;
    private EditText passwordEditText;

    private Button connectBtn;
    private TextView createAccountRedirectBtn;

    private String username;
    private String password;
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        errorConnectAccountTextView = findViewById(R.id.errorConnectAccountTextView);
        controle = Control.getInstance(this);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        connectBtn = findViewById(R.id.connectBtn);
        createAccountRedirectBtn = findViewById(R.id.createAccountRedirectBtn);
        controle = Control.getInstance(this);
        controle.setMainActivity(this);

        databaseManager = new DatabaseManager(getApplicationContext());

        connectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = usernameEditText.getText().toString();
                password = passwordEditText.getText().toString();

                // Faire la requete pour connecter l'utilisateur
                try{
                    controle.connection(usernameEditText.getText().toString(), passwordEditText.getText().toString());
                }catch (Exception e){
                    Log.d("MainActivity", "Erreur dans la fonction listenOnBtnLogin() -> message : " + e.getMessage());
                }
            }
        });

        createAccountRedirectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createAccountActivity = new Intent(getApplicationContext(), CreateAccountActivity.class);
                startActivity(createAccountActivity);
            }
        });

    }

    public void isConnected() {
        if (controle.getAuth()){
            Intent intent = new Intent(MainActivity.this, DashBoardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

    }

    /**
     * Permet de desactivé le button connection
     */
    public void enabledBtnLogin() {
        connectBtn.setEnabled(true);
    }

    /**
     * Permet d'afficher un toast dans l'interface
     * @param message le message a affiché
     */
    public void displayToast(String message){
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

}
package com.example.health_north_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.health_north_app.controleur.Control;


public class DashBoardActivity extends AppCompatActivity {

    private Control controle;
    private ImageButton btnLogoutImg;

    private ImageButton btnDocumentImg;

    private ImageButton btnUserImg;

    private ImageButton btnAppointmentImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        init();

        btnUserImg = findViewById(R.id.btnUserImg);
        btnDocumentImg = findViewById(R.id.btnDocumentImg);
        btnAppointmentImg = findViewById(R.id.btnAppointmentImg);

        btnUserImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoProfileActivity = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(infoProfileActivity);
            }
        });
        btnDocumentImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoDocActivity = new Intent(getApplicationContext(), DocActivity.class);
                startActivity(infoDocActivity);
            }
        });
        btnAppointmentImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoAppointmentListActivity = new Intent(getApplicationContext(), AppointmentListActivity.class);
                startActivity(infoAppointmentListActivity);
            }
        });
    }

    /**
     * Permet d'initialiser l'activity
     */
    private void init(){
        controle = Control.getInstance(this);
        controle.setComeToListProduct(false);
        controle.resetArraysAndContext();
        btnLogoutImg = findViewById(R.id.btnLogoutImg);
        retourLogin();
    }



    /**
     * Ecouteur sur l'ImageButton btnLogoutImg, permet de retourner a l'activity de connection
     */
    public void retourLogin() {
        btnLogoutImg.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v){
                // on reinitialise le controleur vu que l'on quitte la session
                controle.setInstance(null);
                // on relance la gui de connection
                Intent intent = new Intent(DashBoardActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}

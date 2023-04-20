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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        init();
    }

    /**
     * Permet d'initialiser l'activity
     */
    private void init(){
        controle = Control.getInstance(this);
        controle.setComeToListProduct(false);
        controle.resetArraysAndContext();
        btnLogoutImg = findViewById(R.id.btnLogoutImg);
        ecouteMenu((ImageButton)findViewById(R.id.btnDocumentImg), DocumentActivity.class);
        ecouteMenu((ImageButton)findViewById(R.id.btnUserImg), profileActivity.class);
        ecouteMenu((ImageButton)findViewById(R.id.btnAppointmentImg), AppointmentActivity.class);
        retourLogin();
    }

    /**
     * Permet d'ecouter le click sur un object de type ImageButton
     * @param imageButton l'object sur lequel il faut ecouté le click
     * @param classe l"activity a lancé si le button est clické
     */
    private void ecouteMenu(ImageButton imageButton, final Class classe){
        imageButton.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(DashBoardActivity.this, classe);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
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

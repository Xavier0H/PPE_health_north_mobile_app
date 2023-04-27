package com.example.health_north_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.health_north_app.controleur.Control;

import java.util.ArrayList;


public class ProfileActivity extends AppCompatActivity {

    private ImageButton btnBackImg;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnBackImg = findViewById(R.id.btnBack);

        btnBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goDashBoardActivity = new Intent(getApplicationContext(), DashBoardActivity.class);
                startActivity(goDashBoardActivity);
            }
        });
    }
}

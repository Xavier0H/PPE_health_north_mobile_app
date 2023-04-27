package com.example.health_north_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DocActivity extends AppCompatActivity {

    private ImageButton btnBackImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        btnBackImg = findViewById(R.id.btnBack2);

        btnBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goDashBoardActivity = new Intent(getApplicationContext(), DashBoardActivity.class);
                startActivity(goDashBoardActivity);
            }
        });
    }
}
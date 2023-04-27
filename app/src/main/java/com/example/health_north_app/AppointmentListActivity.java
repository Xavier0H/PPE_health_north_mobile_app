package com.example.health_north_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AppointmentListActivity extends AppCompatActivity {

    private ImageButton btnBackImg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_list);

        btnBackImg = findViewById(R.id.btnBack3);

        btnBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goDashBoardActivity = new Intent(getApplicationContext(), DashBoardActivity.class);
                startActivity(goDashBoardActivity);
            }
        });
    }
}
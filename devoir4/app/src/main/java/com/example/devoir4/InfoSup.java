package com.example.devoir4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class InfoSup extends AppCompatActivity {

    ImageView b_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_sup);

        b_back = findViewById(R.id.b_back_info_sup);
        b_back.setOnClickListener(b_backListener);
    }

    View.OnClickListener b_backListener = v -> onBackPressed();
}
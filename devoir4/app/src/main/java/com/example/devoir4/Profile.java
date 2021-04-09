package com.example.devoir4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Profile extends AppCompatActivity {

    ImageView imageMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageMain = findViewById(R.id.imageView8);
        imageMain.setOnClickListener(imageMainListener);
    }

    View.OnClickListener imageMainListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Profile.this, ResultatsRecherche.class));
        }
    };
}
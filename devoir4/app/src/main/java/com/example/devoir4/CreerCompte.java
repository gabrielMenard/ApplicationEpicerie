package com.example.devoir4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CreerCompte extends AppCompatActivity {

    Button inscription;
    ImageView b_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_compte);

        inscription = findViewById(R.id.inscription);
        inscription.setOnClickListener(inscriptionListener);

        b_back = findViewById(R.id.b_back);
        b_back.setOnClickListener(b_backListener);
    }

    View.OnClickListener inscriptionListener = v -> startActivity(new Intent(CreerCompte.this, ResultatChoisi.class));
    View.OnClickListener b_backListener = v -> onBackPressed();
}
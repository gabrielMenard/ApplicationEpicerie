package com.example.devoir4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreerCompte extends AppCompatActivity {

    Button inscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_compte);

        inscription = findViewById(R.id.inscription);
        inscription.setOnClickListener(inscriptionListener);
    }

    View.OnClickListener inscriptionListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(CreerCompte.this, ResultatChoisi.class));
        }
    };
}
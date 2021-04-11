package com.example.devoir4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResultatChoisi extends AppCompatActivity {

    ImageView profil;
    Button voirPlus;
    Button voirAlternative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_choisi);

        profil = findViewById(R.id.imageView2);
        profil.setOnClickListener(profilListener);

        voirPlus = findViewById(R.id.button2);
        voirPlus.setOnClickListener(voirPlusListener);

        voirAlternative = findViewById(R.id.button);
        voirAlternative.setOnClickListener(voirAlternativeListener);

    }

    View.OnClickListener profilListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(ResultatChoisi.this, Modifier.class));
        }
    };

    View.OnClickListener voirPlusListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(ResultatChoisi.this, InfoSup.class));
        }
    };

    View.OnClickListener voirAlternativeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(ResultatChoisi.this, Historique.class));
        }
    };
}
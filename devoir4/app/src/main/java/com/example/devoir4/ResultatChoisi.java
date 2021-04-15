package com.example.devoir4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

public class ResultatChoisi extends AppCompatActivity {

    ImageView b_back_resultat_choisi;
    ImageView profil;
    Button voirPlus;
    Button voirAlternative;
    Button ajoutPanier;

    Snackbar snackbar;


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

        b_back_resultat_choisi = findViewById(R.id.b_back_resultat_choisi);
        b_back_resultat_choisi.setOnClickListener(v -> onBackPressed());

        ajoutPanier = findViewById(R.id.ajout_panier);
        ajoutPanier.setOnClickListener(ajoutListener);

        snackbar = Snackbar.make(findViewById(R.id.constraint),R.string.item_ajoute,Snackbar.LENGTH_SHORT);
    }

    View.OnClickListener profilListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(ResultatChoisi.this, Profile.class));
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
            startActivity(new Intent(ResultatChoisi.this, ResultatsRecherche.class));
        }
    };

    View.OnClickListener ajoutListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            snackbar.show();
        }
    };
}
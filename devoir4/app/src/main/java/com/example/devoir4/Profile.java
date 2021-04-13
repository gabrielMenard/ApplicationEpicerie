package com.example.devoir4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Profile extends AppCompatActivity {

    View historique;
    View modifier;
    View favoris;
    View panier;
    View deconnexion;

    ImageView b_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        b_cancel = findViewById(R.id.b_cancel_profile);
        b_cancel.setOnClickListener(v -> onBackPressed());

        modifier = findViewById(R.id.click_modifier);
        modifier.setOnClickListener(modifierListener);

        historique = findViewById(R.id.click_historique);
        historique.setOnClickListener(historiqueistener);

        favoris = findViewById(R.id.click_favoris);
        favoris.setOnClickListener(favorisListener);

        panier = findViewById(R.id.click_panier);
        panier.setOnClickListener(panierListener);

        deconnexion = findViewById(R.id.click_deconnexion);
        deconnexion.setOnClickListener(deconnexionListener);
    }

    View.OnClickListener historiqueistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Profile.this, ResultatsRecherche.class));
        }
    };

    View.OnClickListener modifierListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Profile.this, Modifier.class));
        }
    };

    View.OnClickListener favorisListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Profile.this, Favoris.class));
        }
    };

    View.OnClickListener panierListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Profile.this, Panier.class));
        }
    };

    View.OnClickListener deconnexionListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Profile.this, Preauthentification.class));
        }
    };
}
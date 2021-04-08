package com.example.devoir4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

// TODO b_profile_sidebar
public class Accueil extends AppCompatActivity {
    Button b_code_barre;
    Button b_rechercher;
    Button b_favoris;
    Button b_historique;
    Button b_panier;
    EditText t_input_mots_cles;
    String motsCles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);

        b_code_barre = findViewById(R.id.b_code_barre);
        b_rechercher = findViewById(R.id.b_rechercher);
        b_favoris = findViewById(R.id.b_favoris);
        b_historique = findViewById(R.id.b_historique);
        b_panier = findViewById(R.id.b_panier);
        t_input_mots_cles = findViewById(R.id.t_input_mots_cles);

        b_rechercher.setOnClickListener(b_rechercherListener);
    }

    View.OnClickListener b_rechercherListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            motsCles = t_input_mots_cles.getText().toString();
            startActivity(new Intent(Accueil.this, Results.class));
        }
    };
}

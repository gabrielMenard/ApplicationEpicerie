package com.example.devoir4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Authentification extends AppCompatActivity {
    Button b_connexion;
    Button b_oublie_password;
    Button creer_compte;
    EditText t_input_email;
    EditText t_input_password;
    String email;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentification);

        t_input_email = findViewById(R.id.t_input_email);
        t_input_password = findViewById(R.id.t_input_password);

        b_connexion = findViewById(R.id.b_connexion);
        b_connexion.setOnClickListener(b_connexionListener);
        b_oublie_password = findViewById(R.id.b_oublie_password);
        creer_compte = findViewById(R.id.b_creer_compte);
    }

    // TODO oublie et creer compte listeners
    View.OnClickListener b_connexionListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            email = t_input_email.getText().toString();
            password = t_input_password.getText().toString();
            startActivity(new Intent(Authentification.this, Accueil.class));
        }
    };
}

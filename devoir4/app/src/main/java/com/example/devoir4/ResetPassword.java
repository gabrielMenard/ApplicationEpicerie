package com.example.devoir4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResetPassword extends AppCompatActivity {

    Button envoie;
    ImageView fermer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password);

        envoie = findViewById(R.id.envoie);
        envoie.setOnClickListener(envoieListener);

        fermer = findViewById(R.id.x_button);
        fermer.setOnClickListener(fermerListener);
    }

    View.OnClickListener envoieListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(ResetPassword.this, CreerCompte.class));
        }
    };

    View.OnClickListener fermerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(ResetPassword.this, Preauthentification.class));
        }
    };
}
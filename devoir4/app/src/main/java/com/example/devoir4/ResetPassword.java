package com.example.devoir4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResetPassword extends AppCompatActivity {

    Button envoie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password);

        envoie = findViewById(R.id.envoie);
        envoie.setOnClickListener(envoieListener);
    }

    View.OnClickListener envoieListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(ResetPassword.this, CreerCompte.class));
        }
    };
}
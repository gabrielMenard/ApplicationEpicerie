package com.example.devoir4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Preauthentification extends AppCompatActivity {
    Button b_guest;
    Button b_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preauthentification);

        b_guest = findViewById(R.id.b_guest);
        b_guest.setOnClickListener(b_guestListener);
        b_signin = findViewById(R.id.b_signin);
        b_signin.setOnClickListener(b_signinListener);
    }

    View.OnClickListener b_guestListener = v -> startActivity(new Intent(Preauthentification.this,Accueil.class));
    View.OnClickListener b_signinListener = v -> startActivity(new Intent(Preauthentification.this, Authentification.class));
}

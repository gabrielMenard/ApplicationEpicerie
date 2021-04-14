package com.example.devoir4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResetPassword extends AppCompatActivity {

    Button envoie;
    ImageView fermer;
    AlertDialog.Builder popup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password);

        envoie = findViewById(R.id.envoie);
        envoie.setOnClickListener(envoieListener);

        fermer = findViewById(R.id.x_button);
        fermer.setOnClickListener(fermerListener);

        popup = new AlertDialog.Builder(this);
        popup.setMessage(R.string.popup).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(ResetPassword.this, Preauthentification.class));
                dialog.cancel();
            }
        });
    }

    View.OnClickListener envoieListener = v -> popup.show();

    View.OnClickListener fermerListener = v -> onBackPressed();
}
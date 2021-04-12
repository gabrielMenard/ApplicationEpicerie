package com.example.devoir4;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

// TODO b_profile_sidebar
public class Accueil extends AppCompatActivity {
    ImageView b_profile;
    Button b_code_barre;
    Button b_rechercher;
    Button b_favoris;
    Button b_historique;
    Button b_panier;
    EditText t_input_mots_cles;
    String barcode;
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
        b_profile = findViewById(R.id.b_profile);

        b_code_barre.setOnClickListener(b_code_barreListener);
        b_rechercher.setOnClickListener(b_rechercherListener);
        b_profile.setOnClickListener(b_profileListener);
        b_favoris.setOnClickListener(b_favorisListener);
        b_historique.setOnClickListener(b_historiqueListener);
        b_panier.setOnClickListener(b_panierListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(intentResult != null) {
            if(intentResult.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                barcode = intentResult.getContents();
                Toast.makeText(this, "Scanned: " + intentResult.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    View.OnClickListener b_rechercherListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            motsCles = t_input_mots_cles.getText().toString();
            startActivity(new Intent(Accueil.this, ResultatsRecherche.class));
        }
    };

    View.OnClickListener b_profileListener = v -> startActivity(new Intent(Accueil.this, Profile.class));
    View.OnClickListener b_favorisListener = v -> startActivity(new Intent(Accueil.this, Favoris.class));
    View.OnClickListener b_historiqueListener = v -> startActivity(new Intent(Accueil.this, Historique.class));
    View.OnClickListener b_panierListener = v -> startActivity(new Intent(Accueil.this, Panier.class));

    View.OnClickListener b_code_barreListener = view -> {
        IntentIntegrator intentIntegrator = new IntentIntegrator(Accueil.this);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
        intentIntegrator.setPrompt("Scanner le code-barres d'un produit pour en\n" +
                                   "  savoir plus sur son empreinte écologique");
        intentIntegrator.setBeepEnabled(false);
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setBarcodeImageEnabled(true);
        intentIntegrator.setCaptureActivity(Scan.class);
        intentIntegrator.initiateScan();
    };
}

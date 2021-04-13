package com.example.devoir4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class Modifier extends AppCompatActivity {

    Spinner spinner;
    ImageView photo;
    ImageView b_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier);

        photo = findViewById(R.id.imageView5);
        photo.setOnClickListener(v -> startActivity(new Intent(Modifier.this, Panier.class)));

        b_cancel = findViewById(R.id.imageView4);
        b_cancel.setOnClickListener(v -> onBackPressed());

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.langues, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
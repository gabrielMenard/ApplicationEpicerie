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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier);

        photo = findViewById(R.id.imageView5);
        photo.setOnClickListener(photoListener);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.langues, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    View.OnClickListener photoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Modifier.this, Panier.class));
        }
    };
}
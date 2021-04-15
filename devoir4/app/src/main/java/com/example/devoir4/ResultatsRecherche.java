package com.example.devoir4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class ResultatsRecherche extends AppCompatActivity {

    ImageView b_back;
    ImageView b_profile;
    RecyclerView recyclerView;
    String[] nom;
    int[] images = new int[] {R.drawable.img_favoris_honeycrisp, R.drawable.image_temp, R.drawable.image_temp, R.drawable.image_temp, R.drawable.image_temp};
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats_recherche);

        nom = getResources().getStringArray(R.array.nom_pomme);

        recyclerView = findViewById(R.id.recyclerview_resulat);
        MyAdapter myAdapter = new MyAdapter(nom, images);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

        b_profile = findViewById(R.id.imageView2);
        b_profile.setOnClickListener(b_profileListener);

        b_back = findViewById(R.id.b_back_resultat_recherche);
        b_back.setOnClickListener(v -> onBackPressed());

        snackbar = Snackbar.make(findViewById(R.id.constraint),R.string.item_ajoute,Snackbar.LENGTH_SHORT);
    }

    class MyAdapter extends RecyclerView.Adapter<MyHolder> {

        String[] nom;
        int[] images;
        String Textbouton;

        MyAdapter(String[] nom, int[] images) {
            super();
            this.nom = nom;
            this.images = images;
            this.Textbouton = getResources().getString(R.string.voir_le_produit);
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.resultats_recherche_layout, parent, false);
            return new MyHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            holder.nom.setText(nom[position]);
            holder.imageView.setImageResource(images[position]);
            holder.ajout.setText(R.string.ajouter_au_panier);
            holder.button.setText(Textbouton);
            holder.button.setOnClickListener(boutonResultatListener);

            holder.ajout.setOnClickListener(ajoutListener);
        }

        @Override
        public int getItemCount() {
            return nom.length;
        }
    }


    class MyHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nom;
        Button ajout;
        Button button;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.image_produit_recherche);
            this.nom = itemView.findViewById(R.id.nom_produit_resultat);
            this.ajout = itemView.findViewById(R.id.ajout);
            this.button = itemView.findViewById(R.id.bouton_resultat);
        }
    }

    View.OnClickListener boutonResultatListener = v -> startActivity(new Intent(ResultatsRecherche.this, ResultatChoisi.class));
    View.OnClickListener b_profileListener = v -> startActivity(new Intent(ResultatsRecherche.this, Profile.class));
    View.OnClickListener ajoutListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            snackbar.show();
        }
    };
}
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

public class ResultatsRecherche extends AppCompatActivity {

    ImageView b_profile;
    RecyclerView recyclerView;
    String[] nom;
    String[] info;
    int[] images = new int[] {R.drawable.image_temp, R.drawable.image_temp, R.drawable.image_temp, R.drawable.image_temp, R.drawable.image_temp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats_recherche);

        nom = getResources().getStringArray(R.array.nom_pomme);
        info = getResources().getStringArray(R.array.info_pomme);

        recyclerView = findViewById(R.id.recyclerview_resulat);
        MyAdapter myAdapter = new MyAdapter(nom, info, images);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

        b_profile = findViewById(R.id.imageView2);
        b_profile.setOnClickListener(b_profileListener);
    }

    class MyAdapter extends RecyclerView.Adapter<MyHolder> {

        String[] nom;
        String[] info;
        int[] images;
        String Textbouton;

        MyAdapter(String[] nom, String[] info, int[] images) {
            super();
            this.nom = nom;
            this.info = info;
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
            holder.info.setText(info[position]);
            holder.button.setText(Textbouton);

            holder.button.setOnClickListener(boutonResultatListener);
        }

        @Override
        public int getItemCount() {
            return nom.length;
        }
    }


    class MyHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nom;
        TextView info;
        Button button;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.image_produit_recherche);
            this.nom = itemView.findViewById(R.id.nom_produit_resultat);
            this.info = itemView.findViewById(R.id.info_produit_resultat);
            this.button = itemView.findViewById(R.id.bouton_resultat);
        }
    }

    View.OnClickListener boutonResultatListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(ResultatsRecherche.this, ResultatChoisi.class));
        }
    };

    View.OnClickListener b_profileListener = v -> startActivity(new Intent(ResultatsRecherche.this, Profile.class));
}
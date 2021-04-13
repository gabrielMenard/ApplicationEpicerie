package com.example.devoir4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Favoris extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] nom;
    int[] images = new int[] {R.drawable.img_favoris_honeycrisp, R.drawable.img_favoris_honeycrisp, R.drawable.img_favoris_honeycrisp};
    ImageView b_profile;
    ImageView b_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoris);

        nom = getResources().getStringArray(R.array.t_favoris_nom);

        // continue HERE TODO
        recyclerView = findViewById(R.id.recycler_view_favoris);
        MyAdapter myAdapter = new MyAdapter(nom, images);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

        b_profile = findViewById(R.id.b_profile);
        b_profile.setOnClickListener(b_profileListener);

        b_back = findViewById(R.id.b_back);
        b_back.setOnClickListener(b_backListener);
    }

    class MyAdapter extends RecyclerView.Adapter<MyHolderFavoris> {
        String[] nom;
        int[] images;

        MyAdapter(String[] nom, int[] images) {
            super();
            this.nom = nom;
            this.images = images;
        }

        @NonNull
        @Override
        public MyHolderFavoris onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favoris_item, parent, false);
            return new MyHolderFavoris(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolderFavoris holder, int position) {
            holder.img_favoris_item.setImageResource(images[position]);
            holder.t_favoris_nom.setText(nom[position]);

            int blanc = ContextCompat.getColor(getBaseContext(), R.color.white);
            int teal = ContextCompat.getColor(getBaseContext(), R.color.teal_700);

            if (position % 2 == 0) {
                holder.itemView.setBackgroundColor(blanc);
            } else {
                holder.itemView.setBackgroundColor(teal);
            }
        }

        @Override
        public int getItemCount() {
            return nom.length;
        }
    }

    class MyHolderFavoris extends RecyclerView.ViewHolder {
        ImageView img_favoris_item;
        ImageView ic_favoris;
        TextView t_favoris_nom;

        MyHolderFavoris(View view) {
            super(view);
            img_favoris_item = view.findViewById(R.id.img_favoris_item);
            ic_favoris = view.findViewById(R.id.ic_favoris);
            t_favoris_nom = view.findViewById(R.id.t_favoris_nom);
        }
    }

    View.OnClickListener b_profileListener = v -> startActivity(new Intent(Favoris.this, Profile.class));
    View.OnClickListener b_backListener = v -> onBackPressed();
}

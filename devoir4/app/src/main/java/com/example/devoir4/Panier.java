package com.example.devoir4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Panier extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] noms;
    int[] imageProduit = new int[] {R.drawable.image_temp, R.drawable.image_temp, R.drawable.image_temp, R.drawable.image_temp, R.drawable.image_temp, R.drawable.image_temp, R.drawable.image_temp, R.drawable.image_temp, R.drawable.image_temp, R.drawable.image_temp};
    int[] empruntes = new int[] {R.drawable.impact_temp,R.drawable.impact_temp,R.drawable.impact_temp,R.drawable.impact_temp,R.drawable.impact_temp,R.drawable.impact_temp,R.drawable.impact_temp,R.drawable.impact_temp,R.drawable.impact_temp,R.drawable.impact_temp};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);

        recyclerView = findViewById(R.id.rv_panier);

        noms = getResources().getStringArray(R.array.noms_produit);

        MyAdapter myAdapter = new MyAdapter(noms, imageProduit, empruntes);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

    }

    class MyAdapter extends  RecyclerView.Adapter<MyHolder> {

        String[] noms;
        int[] imageProduit;
        int[] empruntes;

        MyAdapter(String[] noms, int[] imageProduit, int[] empruntes) {
            super();
            this.noms = noms;
            this.imageProduit = imageProduit;
            this.empruntes = empruntes;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.panier_layout, parent, false);
            return new MyHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            holder.nomProduit.setText(noms[position]);
            holder.emprunte.setImageResource(empruntes[position]);
            holder.imageProduit.setImageResource(imageProduit[position]);
        }

        @Override
        public int getItemCount() {
            return noms.length;
        }
    }

    class  MyHolder extends RecyclerView.ViewHolder {

        ImageView imageProduit;
        ImageView emprunte;
        TextView nomProduit;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageProduit = itemView.findViewById(R.id.photo_produit);
            emprunte = itemView.findViewById(R.id.imageView9);
            nomProduit = itemView.findViewById(R.id.nom_produit);

        }
    }
}
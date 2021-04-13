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
import android.widget.ImageView;
import android.widget.TextView;

public class Historique extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] dates;
    int[] empruntes = new int[] {R.drawable.impact_temp,R.drawable.impact_temp,R.drawable.impact_temp,R.drawable.impact_temp,R.drawable.impact_temp,R.drawable.impact_temp,R.drawable.impact_temp,R.drawable.impact_temp,R.drawable.impact_temp,R.drawable.impact_temp};

    ImageView profile;
    ImageView b_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);
        dates = getResources().getStringArray(R.array.dates);

        profile = findViewById(R.id.imageView2);
        profile.setOnClickListener(profileListener);

        b_back = findViewById(R.id.b_back);

        recyclerView = findViewById(R.id.rv_historique);
        MyAdapter myAdapter = new MyAdapter(dates, empruntes);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }

    View.OnClickListener profileListener = v -> startActivity(new Intent(Historique.this, Profile.class));

    class MyAdapter extends RecyclerView.Adapter<MyHolder> {

        String[] dates;
        int[] empruntes;

        MyAdapter(String[] dates, int[] empruntes) {
            super();
            this.dates = dates;
            this.empruntes = empruntes;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.historique_layout, parent, false);
            return new MyHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            holder.textView.setText(dates[position]);
            holder.imageView.setImageResource(empruntes[position]);
        }

        @Override
        public int getItemCount() {
            return dates.length;
        }
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.date);
            imageView = itemView.findViewById(R.id.emprunte);
        }
    }
}
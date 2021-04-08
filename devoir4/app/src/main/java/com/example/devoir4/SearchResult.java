package com.example.devoir4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class SearchResult extends AppCompatActivity {
    RecyclerView rv_search_result;
    String[]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresult);

        rv_search_result = findViewById(R.id.rv_search_result);
        
    }
}

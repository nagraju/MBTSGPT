package com.example.mbtsgpt.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbtsgpt.model.Home;
import com.example.mbtsgpt.model.Students;

import java.util.List;

public class GalleryScreenAdapter extends RecyclerView.Adapter {
    private Students std;
    private NavController findNavController;

    public GalleryScreenAdapter(Students  std, NavController findNavController) {
        this.std = std;
        this.findNavController = findNavController;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

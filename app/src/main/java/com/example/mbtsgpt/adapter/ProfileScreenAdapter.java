package com.example.mbtsgpt.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbtsgpt.R;
import com.example.mbtsgpt.model.Students;

import java.util.List;


public class ProfileScreenAdapter extends RecyclerView.Adapter<ProfileScreenAdapter.CustomViewHolder> {
    private List<Students> students;
    private NavController findNavController;

    public ProfileScreenAdapter(List<Students> students, NavController findNavController) {
        this.students = students;
        this.findNavController = findNavController;
    }

    // Number of items
    @Override
    public int getItemCount() {
        return students.size();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View cellForRow = layoutInflater.inflate(R.layout.student_view, parent, false);
        return new CustomViewHolder(cellForRow, findNavController);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Students std = students.get(position);
        holder.pin.setText(std.getPin());
        holder.sname.setText(std.getSname());
        holder.sem.setText(std.getSem());
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView pin;
        public TextView sname;
        public TextView sem;


        public CustomViewHolder(View view, final NavController findNavController) {
            super(view);
            pin = view.findViewById(R.id.text_pin);
            sname = view.findViewById(R.id.text_name);
            sem = view.findViewById(R.id.text_sem);

        }
    }
}


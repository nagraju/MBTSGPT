

package com.example.mbtsgpt.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mbtsgpt.model.Marks;
import com.example.mbtsgpt.model.Students;
import com.example.mbtsgpt.R;
import java.util.List;


public class EndexamAdapter extends RecyclerView.Adapter<EndexamAdapter.CustomViewHolder> {
    private List<Marks> marksList;
    private NavController findNavController;
    private Context context;
    private LinearLayoutManager llm;

    public EndexamAdapter(List<Marks> marks,NavController findNavController) {
        this.marksList = marks;
        this.findNavController = findNavController;
    }

    // Number of items
    @Override
    public int getItemCount() {
        return marksList.size();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //context = parent.getContext();
        View cellForRow = layoutInflater.inflate(R.layout.marks_view, parent, false);
        return new CustomViewHolder(cellForRow, findNavController);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Marks marks = marksList.get(position);
        holder.sem.setText(marks.getSem());


       LinearLayoutManager layoutManager
                = new LinearLayoutManager(
                holder.recyclerView2.getContext(),
                LinearLayoutManager.VERTICAL,
                false);
       layoutManager.setInitialPrefetchItemCount(marksList.size());

        holder.recyclerView2.setLayoutManager(layoutManager);
        SubjectsAdapter subjectsAdapter= new SubjectsAdapter(marks.getSubjects(), findNavController);
        holder.recyclerView2.setAdapter(subjectsAdapter);





    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {

        public TextView sem;
        public RecyclerView recyclerView2;


        public CustomViewHolder(View view, final NavController findNavController) {
            super(view);
            sem = view.findViewById(R.id.text_sem);
            recyclerView2 = view.findViewById(R.id.recyclerView2);

        }
    }
}


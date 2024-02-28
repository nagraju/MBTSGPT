package com.example.mbtsgpt.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbtsgpt.R;
import com.example.mbtsgpt.model.Marks;
import com.example.mbtsgpt.model.Subject;

import java.util.List;

public class SubjectsAdapter extends RecyclerView.Adapter<SubjectsAdapter.CustomViewHolder>{


    private List<Subject> subjectList;
    private NavController findNavController;

    public SubjectsAdapter(List<Subject> subjectList, NavController findNavController) {
        this.subjectList = subjectList;
        this.findNavController = findNavController;
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View cellForRow = layoutInflater.inflate(R.layout.subjects_view, parent, false);
        return new CustomViewHolder(cellForRow, findNavController);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Subject  subject = subjectList.get(position);
        holder.sub_code.setText(subject.getSub_code().toString());
        holder.sub_int.setText(subject.getSub_int().toString());
        holder.sub_ext.setText(subject.getSub_ext().toString());
        holder.sub_total.setText(subject.getSub_total().toString());
        holder.sub_status.setText(subject.getSub_status().toString());
    }
    public static class CustomViewHolder extends RecyclerView.ViewHolder {

        public TextView sub_code;
        public TextView sub_int;
        public TextView sub_ext;
        public TextView sub_total;
        public TextView sub_status;


        public CustomViewHolder(View view, final NavController findNavController) {
            super(view);
            sub_code = view.findViewById(R.id.sub_code);
            sub_int = view.findViewById(R.id.sub_internal);
            sub_ext = view.findViewById(R.id.sub_external);
            sub_status = view.findViewById(R.id.sub_status);
            sub_total = view.findViewById(R.id.sub_total);

        }
    }
}

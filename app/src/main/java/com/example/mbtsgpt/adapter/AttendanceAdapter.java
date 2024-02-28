package com.example.mbtsgpt.adapter;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mbtsgpt.model.Attendance;
import com.example.mbtsgpt.model.Students;
import com.example.mbtsgpt.R;
import java.util.List;


public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.CustomViewHolder> {
    private List<Attendance> attendances;
    private NavController findNavController;

    public AttendanceAdapter(List<Attendance> attendances, NavController findNavController) {
        this.attendances = attendances;
        this.findNavController = findNavController;
    }

    // Number of items
    @Override
    public int getItemCount() {
        return attendances.size();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View cellForRow = layoutInflater.inflate(R.layout.attendance_listview, parent, false);
        return new CustomViewHolder(cellForRow, findNavController);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Attendance attendance = attendances.get(position);
        holder.studentclass.setText(attendance.getStudentclass());
        holder.month.setText(attendance.getMonth());
        holder.nfw.setText(attendance.getNfw().toString());
        holder.npd.setText(attendance.getNpd().toString());
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView studentclass;
        public TextView month;
        public TextView nfw;
        public TextView npd;


        public CustomViewHolder(View view, final NavController findNavController) {
            super(view);
            studentclass = view.findViewById(R.id.text_studentclass);
            month = view.findViewById(R.id.text_month);
            nfw = view.findViewById(R.id.text_nfw);
            npd = view.findViewById(R.id.text_npd);

        }
    }
}


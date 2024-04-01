package com.example.mbtsgpt.ui.Attendance;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mbtsgpt.databinding.FragmentAttendanceBinding;

public class AttendanceFragment extends Fragment {

    private FragmentAttendanceBinding binding;
    private LinearLayout linearLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAttendanceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }



    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //default data (department courses)
        AttendancePageData AttendancePageData = new AttendancePageData(binding, Navigation.findNavController(view));
        AttendancePageData.getAttendancePageData();
        binding.recyclerView1.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
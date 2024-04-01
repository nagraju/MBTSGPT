package com.example.mbtsgpt.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mbtsgpt.R;
import com.example.mbtsgpt.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //default data (department courses)
        NavController findNavController ;
        findNavController =  Navigation.findNavController(view);
        binding.profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("last_location", "homePage");
                findNavController.navigate(R.id.action_nav_home_to_nav_profile, bundle);
            }
        });
        binding.results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("last_location", "homePage");
                findNavController.navigate(R.id.action_nav_home_to_nav_endexam, bundle);

            }
        });
        binding.attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("last_location", "homePage");
                findNavController.navigate(R.id.action_nav_home_to_nav_Attendance, bundle);

            }
        });





    }



}
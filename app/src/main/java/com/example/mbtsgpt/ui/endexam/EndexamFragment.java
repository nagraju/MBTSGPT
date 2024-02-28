package com.example.mbtsgpt.ui.endexam;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mbtsgpt.R;
import com.example.mbtsgpt.databinding.FragmentEndexamBinding;
import com.example.mbtsgpt.databinding.FragmentGalleryBinding;
import com.example.mbtsgpt.ui.gallery.GalleryPageData;


public class EndexamFragment extends Fragment {


    private FragmentEndexamBinding binding;
    private LinearLayout linearLayout;

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //default data (department courses)
        EndExamPageData endExamPageData = new EndExamPageData(binding, Navigation.findNavController(view));
        endExamPageData.getPageData();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentEndexamBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;

    }
}
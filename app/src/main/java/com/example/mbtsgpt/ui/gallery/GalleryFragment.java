package com.example.mbtsgpt.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mbtsgpt.databinding.FragmentGalleryBinding;
import com.example.mbtsgpt.ui.home.HomePageData;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private LinearLayout linearLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }



    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //default data (department courses)
        GalleryPageData galleryPageData = new GalleryPageData(binding, Navigation.findNavController(view));
        galleryPageData.getGalleryPageData();
        binding.recyclerView1.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.example.mbtsgpt.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbtsgpt.R;
import com.example.mbtsgpt.adapter.AttendanceAdapter;
import com.example.mbtsgpt.api.RetrofitBuilder;
import com.example.mbtsgpt.databinding.FragmentGalleryBinding;
import com.example.mbtsgpt.model.Home;
import com.example.mbtsgpt.model.Students;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryPageData extends RetrofitBuilder {

    private FragmentGalleryBinding binding;
    private NavController findNavController;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;

    public  GalleryPageData(FragmentGalleryBinding binding, NavController findNavController){
        this.findNavController = findNavController;
        this.recyclerView1 = binding.recyclerView1;
        //this.recyclerView2 = binding.recyclerView2;
        this.binding = binding;

    }

    public void getGalleryPageData() {
        Call<Home> retrofitData;
        retrofitData = retrofitBuilder.getHomeData();

        retrofitData.enqueue(new Callback<Home>() {
            @Override
            public void onResponse(Call<Home> call, Response<Home> response) {
                Home home = response.body();
                try {
                    binding.textName.setText(home.getStudents().getSname());
                    binding.textPin.setText(home.getStudents().getPin());
                    recyclerView1.setAdapter(new AttendanceAdapter(home.getAttendances(), findNavController));
                } catch (Exception e) {
                    Log.i("error", "empty results");
                }
            }

            @Override
            public void onFailure(Call<Home> call, Throwable t) {
                Bundle bundle = new Bundle();
                bundle.putString("last_location", "homePage");
                findNavController.navigate(R.id.action_nav_home_to_connetion_error, bundle);
                Log.i("FirstFragment", t.getMessage());
            }
        });




    }



}

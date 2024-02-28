package com.example.mbtsgpt.ui.home;

import android.os.Bundle;
import android.util.Log;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mbtsgpt.R;
import com.example.mbtsgpt.adapter.HomeScreenAdapter;
import com.example.mbtsgpt.api.RetrofitBuilder;
import com.example.mbtsgpt.model.Students;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class HomePageData extends RetrofitBuilder {
    private RecyclerView recyclerView;
    private NavController findNavController;

    public HomePageData(RecyclerView recyclerView, NavController findNavController) {
        this.recyclerView = recyclerView;
        this.findNavController = findNavController;
    }

    public void getHomePageData() {
        Call<List<Students>> retrofitData;
        retrofitData = retrofitBuilder.getStudent();
        Log.i("error", "Home Page Data");
        retrofitData.enqueue(new Callback<List<Students>>() {
            @Override
            public void onResponse(Call<List<Students>> call, Response<List<Students>> response) {
                List<Students> students = response.body();
                try {
                    recyclerView.setAdapter(new HomeScreenAdapter(students, findNavController));
                } catch (Exception e) {
                    Log.i("error", "empty results");
                }
            }

            @Override
            public void onFailure(Call<List<Students>> call, Throwable t) {
                Bundle bundle = new Bundle();
                bundle.putString("last_location", "homePage");
                findNavController.navigate(R.id.action_nav_home_to_connetion_error, bundle);
                Log.i("FirstFragment", t.getMessage());
            }
        });
    }
}
package com.example.mbtsgpt.ui.endexam;

import android.os.Bundle;
import android.util.Log;

import com.example.mbtsgpt.adapter.AttendanceAdapter;
import com.example.mbtsgpt.databinding.FragmentEndexamBinding;

import com.example.mbtsgpt.model.EndExamPage;
import com.example.mbtsgpt.model.Home;

import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbtsgpt.R;
import com.example.mbtsgpt.adapter.EndexamAdapter;
import com.example.mbtsgpt.api.RetrofitBuilder;
import com.example.mbtsgpt.databinding.FragmentGalleryBinding;
import com.example.mbtsgpt.model.Home;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EndExamPageData extends RetrofitBuilder{

    private FragmentEndexamBinding binding;
    private NavController findNavController;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;


    public EndExamPageData(FragmentEndexamBinding binding, NavController findNavController){
            this.findNavController = findNavController;
            this.recyclerView1 = binding.recyclerView;
            //this.recyclerView2 = binding.recyclerView2;
            this.binding = binding;
        }



    public void getPageData()
    {
        Call<EndExamPage> retrofitData;
        retrofitData = retrofitBuilder.getEndExam();
        retrofitData.enqueue(new Callback<EndExamPage>() {
            @Override
            public void onResponse(Call<EndExamPage> call, Response<EndExamPage> response) {
                EndExamPage endExamPage = response.body();
                try {
                    binding.textName.setText(endExamPage.getStudents().getSname());
                    binding.textPin.setText(endExamPage.getStudents().getPin());
                    EndexamAdapter ea = new EndexamAdapter(endExamPage.getMarks(),findNavController);
                    recyclerView1.setAdapter(ea);
                } catch (Exception e) {
                    Log.i("error", "empty results");
                }
            }

                @Override
                public void onFailure(Call<EndExamPage> call, Throwable t) {
                    Bundle bundle = new Bundle();
                    bundle.putString("last_location", "homePage");
                    findNavController.navigate(R.id.action_nav_home_to_connetion_error, bundle);
                    Log.i("FirstFragment", t.getMessage());
                }
            });





        }
}


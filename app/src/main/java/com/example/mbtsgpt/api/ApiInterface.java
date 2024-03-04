package com.example.mbtsgpt.api;

import com.example.mbtsgpt.model.*;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Response;
import java.util.List;
import retrofit2.http.*;

public interface ApiInterface {
    @POST("/api/login/")
    Call<JwtResponse> loginUser(@Body JwtUserRequest user);

    @GET("/api/student/")
    Call<List<Students>>getStudent();

    @GET("/n/home/")
    Call <Home>getHomeData();


    @GET("/api/marks/")
    Call <EndExamPage>getEndExam();


}


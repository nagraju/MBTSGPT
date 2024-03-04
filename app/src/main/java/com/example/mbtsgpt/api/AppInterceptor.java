package com.example.mbtsgpt.api;


import com.example.mbtsgpt.ui.login.roomdatabase.ResponseUserDetails;
import com.example.mbtsgpt.ui.login.roomdatabase.UserEntity;
import com.example.mbtsgpt.utils.GetUserDetails;
import com.example.mbtsgpt.utils.MyApp;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AppInterceptor implements Interceptor {
    //private final String jwtToken1 = new GetUserDetails().getData(MyApp.getInstance()).getJwtToken();

    //private final String validTokenValue = "Bearer " + jwtToken;

    @Override
    public Response intercept(Chain chain) throws IOException {
        final String jwtToken;
        UserEntity responseUserDetails = new GetUserDetails().getData(MyApp.getInstance());
        if (responseUserDetails != null)
           jwtToken = "Bearer  " + responseUserDetails.getJwtToken();
        else
            jwtToken = "";

        Request request = chain.request()
                .newBuilder()
                .addHeader("Authorization", jwtToken)
                .build();
        //    .addHeader("auth-token", jwtToken)
        return chain.proceed(request);
    }
}


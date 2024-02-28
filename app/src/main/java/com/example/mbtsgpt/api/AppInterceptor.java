package com.example.mbtsgpt.api;


import com.example.mbtsgpt.utils.GetUserDetails;
import com.example.mbtsgpt.utils.MyApp;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AppInterceptor implements Interceptor {
    private final String jwtToken = "" ;//new GetUserDetails().getData(MyApp.getInstance()).getJwtToken();
    private final String validTokenValue = "Bearer " + jwtToken;

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request()
                .newBuilder()
                .addHeader("auth-token", validTokenValue)
                .build();
        return chain.proceed(request);
    }
}


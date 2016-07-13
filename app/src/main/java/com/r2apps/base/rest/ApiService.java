package com.r2apps.base.rest;

import com.r2apps.base.model.request.LoginRequest;
import com.r2apps.base.model.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by user on 7/12/2016.
 */
public interface ApiService {
    @POST("login")
    Observable<LoginResponse> login(@Body LoginRequest loginRequest);
}

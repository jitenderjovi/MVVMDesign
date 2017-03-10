package com.example.jitu.mvvmdesign.serviceRequest;

import com.example.jitu.mvvmdesign.model.UserResponse;
import com.example.jitu.mvvmdesign.model.WeatherData;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Jitu on 02/03/17.
 */

interface LoginAPI  {
    @FormUrlEncoded
    @POST("login")
    Call<UserResponse> callloginAPI(
            @Field("email") String email,
            @Field("password") String password,
            @Field("device_token") String device_token,
            @Field("device_type") String device_type);

    @FormUrlEncoded
    @POST("login")
    Call<UserResponse> callloginAPIMap(@FieldMap(encoded = true) Map<String, String> fields);


}
package com.example.jitu.mvvmdesign.serviceRequest;




import com.example.jitu.mvvmdesign.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    Call<UserResponse> callloginAPI(@Field("email") String email, @Field("password") String password, @Field("device_token") String device_token, @Field("device_type") String device_type);
}

package com.example.jitu.mvvmdesign.serviceRequest;



import com.example.jitu.mvvmdesign.model.UserResponse;
import com.example.jitu.mvvmdesign.model.WeatherData;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Jitu on 07/10/16.
 */

public interface ServiceAPI  {
    @GET( "weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1" )
    Call<WeatherData> getweatherdata();

}

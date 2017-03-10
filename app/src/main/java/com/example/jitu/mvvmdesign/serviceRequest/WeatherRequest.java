package com.example.jitu.mvvmdesign.serviceRequest;

import com.example.jitu.mvvmdesign.model.Data;
import com.example.jitu.mvvmdesign.model.UserResponse;
import com.example.jitu.mvvmdesign.model.Weather;
import com.example.jitu.mvvmdesign.model.WeatherData;
import com.example.jitu.mvvmdesign.network.ApiClient;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Jitu on 09/03/17.
 */

public class WeatherRequest {
    private ServiceAPI weatherRequestAPI;
    public WeatherRequest(){
        weatherRequestAPI = ApiClient.createService(ServiceAPI.class);
    }

    public void getWeather(String params, final ServiceCallback.WeatherServiceCallback weatherServiceCallback){
        final Call<WeatherData> call = weatherRequestAPI.getweatherdata();
        ApiClient.hitServer(call, new ServiceCallback<WeatherData>(){

            @Override
            public void onSuccess(Response<WeatherData> response) {


               List<Weather> weatherList = response.body().getWeather();
                System.out.println(response.body().toString());

            }

            @Override
            public void onError(String header, String message) {
                weatherServiceCallback.onError(header,message);

            }
        });
    }
}

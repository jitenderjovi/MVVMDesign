package com.example.jitu.mvvmdesign.serviceRequest;

import com.example.jitu.mvvmdesign.model.Data;
import com.example.jitu.mvvmdesign.model.UserResponse;
import com.example.jitu.mvvmdesign.model.Weather;

import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jitu on 01/03/17.
 */

public interface ServiceCallback<T>  {
    void onSuccess(Response<T> response);
    void onError(String header, String message);

     interface LoginServiceCallback {

        void onSuccess(Data userResponse);
        void onError(String header, String message);
    }
    interface WeatherServiceCallback {

        void onSuccess(Weather weather);
        void onError(String header, String message);
    }


}

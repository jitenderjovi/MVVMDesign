package com.example.jitu.mvvmdesign.serviceRequest;


import com.example.jitu.mvvmdesign.model.Data;
import com.example.jitu.mvvmdesign.model.UserResponse;
import com.example.jitu.mvvmdesign.network.AdeptAndroid;
import com.example.jitu.mvvmdesign.network.ApiClient;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jitu on 05/10/16.
 */

public class LoginRequest extends BaseRequest {

    private  LoginAPI loginAPI;


    public LoginRequest(){
        loginAPI = ApiClient.createService(LoginAPI.class);

    }

    public void getLoginwithMap(Map params, final ServiceCallback.LoginServiceCallback loginServiceCallback){
        final Call<UserResponse> call = loginAPI.callloginAPIMap(params);
        ApiClient.hitServer(call, new ServiceCallback<UserResponse>(){

            @Override
            public void onSuccess(Response<UserResponse> response) {


                Data data = response.body().getData();
                System.out.println(response.body().getData().getTribe_user());
                UserResponse userResponse = response.body();
                if(userResponse.getStatus().equalsIgnoreCase("success")) {
                    AdeptAndroid.getInstance().setUserdata(data);
                    loginServiceCallback.onSuccess(userResponse.getData());
                } else {
                    loginServiceCallback.onError("API message",userResponse.getMessage());
                }
            }

            @Override
            public void onError(String header, String message) {
                loginServiceCallback.onError(header,message);

            }
        });
    }


}

package com.example.jitu.mvvmdesign.viewmodel;

import android.content.Context;
import android.content.res.ColorStateList;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.TextView;


import com.example.jitu.mvvmdesign.Activity.AppNavigator;
import com.example.jitu.mvvmdesign.model.Data;
import com.example.jitu.mvvmdesign.model.SimpleTextWatcher;
import com.example.jitu.mvvmdesign.adapter.TextWatcherAdapter;
import com.example.jitu.mvvmdesign.model.UserResponse;

import com.example.jitu.mvvmdesign.model.Weather;
import com.example.jitu.mvvmdesign.serviceRequest.LoginRequest;

import com.example.jitu.mvvmdesign.serviceRequest.ServiceCallback;
import com.example.jitu.mvvmdesign.serviceRequest.WeatherRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Response;


/**
 * Created by Jitu on 20/02/17.
 */

public class LoginViewModel  {

    public final ObservableField<String> email =
            new ObservableField<>();
    public final ObservableField<String> password =
            new ObservableField<>();
    public final ObservableField<String> confpassword =
            new ObservableField<>();

    public final ObservableField<String>  errormsg = new ObservableField<>();
    public final ObservableInt color = new ObservableInt();
   // public final ObservableField<ColorStateList>  color = new ObservableField<>();

    public final ObservableField<String> emailerror =  new ObservableField<>();
    public final ObservableField<String> passworderror =  new ObservableField<>();
    public final ObservableField<String> confpassworderror =  new ObservableField<>();


    private final AppNavigator appNavigator;

      public LoginViewModel(Context context,AppNavigator appNavigator){
        this.appNavigator = appNavigator;
}


    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

    public final static boolean isValidEmail(CharSequence target) {

        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }



    public final void showData() {

        appNavigator.hideSoftKeyboard();
        if(checkPasswordMatch()){
            Map params = new HashMap();
            params.put("email", "test@test.com");
            params.put("password", "123123");
            params.put("email", email.get());
            params.put("password", password.get());
            params.put("device_type", "ios");
            params.put("device_token", "123423423");
            System.out.println(confpassword.get()+"==="+email.get()+"==="+password.get()+"hit for API");

//            new WeatherRequest().getWeather("", new ServiceCallback.WeatherServiceCallback() {
//                @Override
//                public void onSuccess(Weather weather) {
//
//                }
//
//                @Override
//                public void onError(String header, String message) {
//
//                }
//            });



            new LoginRequest().getLoginwithMap(params, new ServiceCallback.LoginServiceCallback() {


                @Override
                public void onSuccess(Data data) {
                    errormsg.set("Login success");
                    color.set(Color.GREEN);
                    System.out.println("tribe user----"+data.getTribe_user());
                    appNavigator.gotoNextActivity();

                }

                @Override
                public void onError(String header, String message) {
                    errormsg.set(message);
                    color.set(Color.RED);

                }
            });
        }

    }



    public boolean checkPasswordMatch(){
        errormsg.set(null);

        System.out.println(confpassword.get()+"==="+email.get()+"==="+password.get());
        if(!confpassword.get().equals(password.get())){
            confpassworderror.set("password not matched");
            return false;
        } else {
            confpassworderror.set(null);
            return true;
        }
    }

    public TextWatcher onEmailtextchange = new SimpleTextWatcher() {

        @Override
        public void onTextChanged(String newBasic) {
            errormsg.set(null);
            System.out.println("new basic=="+newBasic);
            if(!isValidEmail(newBasic)){
                emailerror.set("Please enter correct email");
            } else {
                emailerror.set(null);
            }

        }
    };

    public TextWatcher onPasswordTextChange = new SimpleTextWatcher() {
        @Override
        public void onTextChanged(String text) {
            errormsg.set(null);
            System.out.println("new basic=="+text);
            if(!isValidPassword(text)){
                passworderror.set("enter correct password");
            }else {
                passworderror.set(null);
            }

        }
    };


}

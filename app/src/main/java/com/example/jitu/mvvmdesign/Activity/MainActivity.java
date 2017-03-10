package com.example.jitu.mvvmdesign.Activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.inputmethod.InputMethodManager;
import android.widget.ScrollView;


import com.example.jitu.mvvmdesign.R;
import com.example.jitu.mvvmdesign.databinding.ActivityMainBinding;
import com.example.jitu.mvvmdesign.model.Data;
import com.example.jitu.mvvmdesign.network.AdeptAndroid;
import com.example.jitu.mvvmdesign.viewmodel.LoginViewModel;

import java.io.File;

import okhttp3.Cache;

public class MainActivity extends AppCompatActivity implements AppNavigator {



    private ScrollView backgroundscrolll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginViewModel loginViewModel = new LoginViewModel(getApplicationContext(),this);


        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setLoginviewModel(loginViewModel);
        backgroundscrolll = (ScrollView) findViewById(R.id.backgroundscroll);


        Cache cache = null;
        try
        {
            cache = new Cache( new File( getApplicationContext().getCacheDir(), "http-cache" ),
                    10 * 1024 * 1024 ); // 10 MB
            System.out.println("create Cache!");
        }
        catch (Exception e)
        {
            System.out.println("Could not create Cache!"+e.getMessage());
            //Timber.e( e, "Could not create Cache!" );
        }



    }

    public void hideSoftKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    @Override
    public void gotoNextActivity() {
        Intent intent = new Intent(this, UserDetailActivity.class);

        startActivityForResult(intent, UserDetailActivity.REQUEST_CODE);

        System.out.println("next activity");
    }


}

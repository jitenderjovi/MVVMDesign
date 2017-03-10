package com.example.jitu.mvvmdesign.network;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.compat.BuildConfig;

import com.example.jitu.mvvmdesign.model.Data;

/**
 * Created by Jitu on 08/03/17.
 */

public class AdeptAndroid extends Application {

    private static AdeptAndroid instance;

    private  Data userdata;

    @Override
    public void onCreate()
    {
        super.onCreate();

        instance = this;

        if (BuildConfig.DEBUG)
        {
            System.out.println("Creating our Application in");
            //Timber.plant(new Timber.DebugTree());
        }

        System.out.println("Creating our Application");
    }


    public static AdeptAndroid getInstance ()
    {
        return instance;
    }

    public static boolean hasNetwork ()
    {
        return instance.checkIfHasNetwork();
    }

    public boolean checkIfHasNetwork()
    {
        ConnectivityManager cm = (ConnectivityManager) getSystemService( Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public Data getUserdata() {
        return userdata;
    }

    public void setUserdata(Data userdata) {
        this.userdata = userdata;
    }
}

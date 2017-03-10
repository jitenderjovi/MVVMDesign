package com.example.jitu.mvvmdesign.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.example.jitu.mvvmdesign.model.Data;

/**
 * Created by Jitu on 07/03/17.
 */

public class UserDetailViewModel extends BaseObservable {

    public final ObservableField<String> email =
            new ObservableField<>();
    public final ObservableField<String> name =
            new ObservableField<>();
    public final ObservableField<String> accesstoken =
            new ObservableField<>();


    public UserDetailViewModel(Data userdata){
        this.email.set(userdata.getEmail());
        this.name.set(userdata.getName());
        this.accesstoken.set(userdata.getAccess_token());
    }





}

package com.example.jitu.mvvmdesign.Activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.jitu.mvvmdesign.R;
import com.example.jitu.mvvmdesign.databinding.ActivityUserDetailBinding;
import com.example.jitu.mvvmdesign.model.Data;
import com.example.jitu.mvvmdesign.network.AdeptAndroid;
import com.example.jitu.mvvmdesign.viewmodel.TribeList;
import com.example.jitu.mvvmdesign.viewmodel.UserDetailViewModel;


public class UserDetailActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    public Data userdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        ActivityUserDetailBinding activityUserDetail = DataBindingUtil.setContentView(this, R.layout.activity_user_detail);
        activityUserDetail.setUserdetail(new UserDetailViewModel(AdeptAndroid.getInstance().getUserdata()));

        TribeList tribeList = new TribeList(AdeptAndroid.getInstance().getUserdata().getTribe_user());

        activityUserDetail.setTribelist(tribeList);
    }
}

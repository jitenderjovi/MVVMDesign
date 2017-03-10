package com.example.jitu.mvvmdesign.viewmodel;

import android.databinding.ObservableArrayList;

import com.example.jitu.mvvmdesign.model.Tribe;
import com.example.jitu.mvvmdesign.model.TribeUser;

import java.util.List;

/**
 * Created by Jitu on 10/03/17.
 */

public class TribeList {
    public ObservableArrayList<TribeUser> list = new ObservableArrayList<>();

    public TribeList(List<TribeUser> tribeList){
    list.addAll(tribeList);
    }

    private void add(TribeUser info) {
        list.add(info);
    }
}

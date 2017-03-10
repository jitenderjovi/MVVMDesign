package com.example.jitu.mvvmdesign.adapter;

import android.databinding.BaseObservable;
import android.text.TextUtils;

/**
 * Created by Jitu on 23/02/17.
 */

public class BindableString extends BaseObservable {
    private String value;
    public String get() {
        return value != null ? value : "";
    }
    public void set(String value) {
        if (!TextUtils.equals(this.value, value)) {
            this.value = value;
            notifyChange();
        }
    }
    public boolean isEmpty() {
        return value == null || value.isEmpty();
    }
}

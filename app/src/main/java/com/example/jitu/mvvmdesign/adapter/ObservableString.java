package com.example.jitu.mvvmdesign.adapter;

import android.databinding.BaseObservable;

/**
 * Created by Jitu on 23/02/17.
 */

public class ObservableString extends BaseObservable
{
    private String value;

    public String get()
    {
        return value != null ? value : "";
    }

    public void set(String value)
    {
        if (equals(this.value, value) == false)
        {
            this.value = value;
            notifyChange();
        }
    }

    public static boolean equals(Object a, Object b)
    {
        return (a == null) ? (b == null) : a.equals(b);
    }
}

package com.example.jitu.mvvmdesign.adapter;

import android.content.res.ColorStateList;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jitu.mvvmdesign.model.Tribe;
import com.example.jitu.mvvmdesign.model.TribeUser;
import com.squareup.picasso.Picasso;

/**
 * Created by Jitu on 03/03/17.
 */

public class TextViewAdapter {

    @BindingAdapter({"bind:font"})
    public static void setFont(TextView textView, int textcolor) {
        textView.setTextColor(ColorStateList.valueOf(textcolor));
    }

    @BindingAdapter("bind:items")
    public static void bindList(RecyclerView view, ObservableArrayList<TribeUser> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        view.setLayoutManager(layoutManager);
        view.setAdapter(new TribesAdapter(list));
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        if (!url.equals("")) {
            Picasso.with(imageView.getContext()).load(url).resize(200, 200).into(imageView);
        }
    }

}

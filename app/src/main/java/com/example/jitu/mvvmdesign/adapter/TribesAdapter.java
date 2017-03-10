package com.example.jitu.mvvmdesign.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jitu.mvvmdesign.R;
import com.example.jitu.mvvmdesign.databinding.CustomRowBinding;
import com.example.jitu.mvvmdesign.model.Tribe;
import com.example.jitu.mvvmdesign.model.TribeUser;

/**
 * Created by Jitu on 09/03/17.
 */

public class TribesAdapter extends RecyclerView.Adapter<TribesAdapter.ViewHolder> {
    @Override
    public TribesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TribesAdapter.ViewHolder holder, int position) {
        TribeUser tribe = list.get(position);
        holder.binder.setTribeinfo(tribe);
        holder.binder.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private ObservableArrayList<TribeUser> list;
    public TribesAdapter(ObservableArrayList<TribeUser> tribelist){
        list = tribelist;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CustomRowBinding binder;
        public TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            binder =  DataBindingUtil.bind(itemView);
        }
    }
}

package com.andy.popularmovies.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewjoyce on 08/03/2017.
 */

public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private ArrayList<T> data = new ArrayList<>();

    public abstract VH onCreateCustomViewHolder(ViewGroup parent, int viewType);
    public abstract void onBindCustomViewHolder(VH holder, int position);

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateCustomViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        onBindCustomViewHolder(holder, position);
    }

    public void setContent(List<T> content) {
        data.clear();
        data.addAll(content);
        notifyDataSetChanged();
    }

    public T getItemAtPosition(int position) {
        return data.get(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

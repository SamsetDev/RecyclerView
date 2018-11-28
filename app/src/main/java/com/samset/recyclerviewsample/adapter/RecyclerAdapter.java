package com.samset.recyclerviewsample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.samset.recyclerviewsample.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by samset on 23/03/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder> {
    Context context;
    List<String> itemList;
    String strDomain;

    public RecyclerAdapter(Context contectxxt, List<String> item) {
        this.context = contectxxt;
        this.itemList = item;


    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder holder = null;
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item, parent, false);
        holder = new MyHolder(v);

        return holder;

    }


    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        holder.name.setText(itemList.get(position));
        animate(holder);

    }


    @Override
    public int getItemCount() {

        if (itemList == null || itemList.size() == 0) {
            return 0;
        }

        // +1 for loader
        return itemList.size();

    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        public TextView name;
        


        public MyHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);


        }
    }

    // add animation
    public void animate(RecyclerView.ViewHolder viewHolder) {
        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.overshoot);
        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
    }

}
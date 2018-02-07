package com.example.root.expadablerecycleview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.root.expadablerecycleview.R;

/**
 * Created by root on 2/7/18.
 */

public class MyViewChild extends RecyclerView.ViewHolder {
   public TextView textView;
    public MyViewChild(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textviewWithoutChild);
    }
}

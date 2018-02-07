package com.example.root.expadablerecycleview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.root.expadablerecycleview.R;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;

/**
 * Created by root on 2/7/18.
 */

public class MyViewParent extends RecyclerView.ViewHolder {
    public TextView textView,textViewWithChild;
    public RelativeLayout relativeLayout;
    public ExpandableLinearLayout expandableLayout;
    public MyViewParent(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textview);
        textViewWithChild = itemView.findViewById(R.id.textviewWithChild);
        relativeLayout = itemView.findViewById(R.id.button);
        expandableLayout = itemView.findViewById(R.id.ex_layout);

    }
}

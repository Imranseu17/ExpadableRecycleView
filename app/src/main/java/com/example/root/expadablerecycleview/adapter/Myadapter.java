package com.example.root.expadablerecycleview.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.root.expadablerecycleview.R;
import com.example.root.expadablerecycleview.model.Item;
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.Utils;

import java.util.List;

/**
 * Created by root on 2/7/18.
 */

public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<Item> itemList;
    Context context;
    SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();

    public Myadapter(List<Item> itemList) {
        this.itemList = itemList;
        for(int i = 0; i < itemList.size(); i++){
            sparseBooleanArray.append(i,false);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(itemList.get(position).isExpandable()){
            return 1;
        }
        else
            return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        if(viewType == 0){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.layout_without_child,
                    parent,false);
            return new MyViewChild(view);
        }

        else {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.layout_with_chlid,
                    parent,false);
            return new MyViewChild(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        switch (holder.getItemViewType()){
            case 0:{
              final MyViewChild viewHolderWithoutChild =
                      (MyViewChild)holder;
                Item item  = itemList.get(position);
                viewHolderWithoutChild.setIsRecyclable(false);
                viewHolderWithoutChild.textView.setText(item.getText());
            }
            break;

            case 1:{
               final MyViewParent viewHolderWithChild = (MyViewParent) holder;
                Item item  = itemList.get(position);
                viewHolderWithChild.setIsRecyclable(false);
                viewHolderWithChild.textView.setText(item.getText());

                viewHolderWithChild.expandableLayout.setInRecyclerView(true);
                viewHolderWithChild.expandableLayout.setExpanded
                        (sparseBooleanArray.get(position));
                viewHolderWithChild.expandableLayout.setListener(new ExpandableLayoutListenerAdapter
                        () {
                    @Override
                    public void onPreOpen() {

                        changeRotate(viewHolderWithChild.relativeLayout,0f,180f).start();
                        sparseBooleanArray.put(position,true);

                    }

                    @Override
                    public void onPreClose() {
                        changeRotate(viewHolderWithChild.relativeLayout,180f,0f).start();
                        sparseBooleanArray.put(position,false);

                    }

                });

              viewHolderWithChild.relativeLayout.
                      setRotation(sparseBooleanArray.get(position)?180f:0f);

                viewHolderWithChild.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewHolderWithChild.expandableLayout.toggle();
                    }
                });

                viewHolderWithChild.textViewWithChild.
                        setText(itemList.get(position).getSubtext());
            }
            break;

            default:
                break;


        }

    }

    private ObjectAnimator changeRotate(RelativeLayout relativeLayout, float from, float to) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(relativeLayout,
                "rotation",from,to);
        animator.setDuration(300);
        animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
        return animator;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

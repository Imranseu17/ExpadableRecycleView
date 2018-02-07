package com.example.root.expadablerecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.root.expadablerecycleview.adapter.Myadapter;
import com.example.root.expadablerecycleview.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView list;
    RecyclerView.LayoutManager layoutManager;
    List<Item> itemList  = new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.recycler);
        list.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);

        setData();
    }

    private void setData() {

        for (int i = 0; i < 20; i++){
            if (i%2 == 0){
                Item item = new Item("This is Item "+(i+1),
                        "This is child item "+(i+1),true);
                itemList.add(item);
            }

            else {
                    Item item = new Item("This is item "+(i+1)," ",false);
                    itemList.add(item);
            }
        }

        Myadapter myadapter = new Myadapter(itemList);
        list.setAdapter(myadapter);
    }
}

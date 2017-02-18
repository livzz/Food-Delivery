package com.foodypark.foodypark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.foodypark.foodypark.adapter.GlobalAdapter;
import com.foodypark.foodypark.restaurant.MenuInfo;
import com.foodypark.foodypark.restaurant.MenuItems;
import com.foodypark.foodypark.restaurant.MenuItemsImage;
import com.foodypark.foodypark.restaurant.RestaurantsInfo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setUpRecyclerView();
    }

    private void setUpToolbar() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("FoodyPark");
        toolbar.setSubtitle("Change location");
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GlobalAdapter adapter = new GlobalAdapter(this, getSampleArrayList());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this); // (Context context, int spanCount)
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private ArrayList<Object> getSampleArrayList() {
        String url = "https://s3.ap-south-1.amazonaws.com/foodypark/item.jpg";
        ArrayList<Object> data = new ArrayList<>();
        data.add("hello");
        data.add(1);
        for(int i = 1;i<5;i++) {
            ArrayList<String> a = new ArrayList<>();
            a.add("Menu 1");
            a.add("Menu 2");
            a.add("Menu 3");
            a.add("Menu 4");
            ArrayList<MenuInfo> info = new ArrayList<>();
            ArrayList<MenuItemsImage> imageItems = new ArrayList<>();
            imageItems.add(new MenuItemsImage("Item1",100,url));
            imageItems.add(new MenuItemsImage("Item2",200,url));
            imageItems.add(new MenuItemsImage("Item3",300,url));
            imageItems.add(new MenuItemsImage("Item4",400,url));
            for (String x : a) {
                ArrayList<MenuItems> items = new ArrayList<>();

                items.add(new MenuItems("Item1", 100));
                items.add(new MenuItems("Item2", 200));
                items.add(new MenuItems("Item3", 300));
                items.add(new MenuItems("Item4", 400));
                items.add(new MenuItems("Item5", 500));
                info.add(new MenuInfo(x, items));
            }
            data.add(new RestaurantsInfo("30 min","Restaurant "+i,"Location "+i,"https://s3.ap-south-1.amazonaws.com/foodypark/restaurant.png","18-2-2017",info,imageItems));
        }
        return data;
    }
}
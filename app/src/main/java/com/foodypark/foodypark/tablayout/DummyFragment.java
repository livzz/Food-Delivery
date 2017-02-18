package com.foodypark.foodypark.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foodypark.foodypark.R;
import com.foodypark.foodypark.Restaurant_Items;
import com.foodypark.foodypark.adapter.GlobalAdapter;
import com.foodypark.foodypark.restaurant.MenuItems;
import com.foodypark.foodypark.restaurant.MenuItemsImage;
import com.foodypark.foodypark.restaurant.RestaurantsInfo;

import java.util.ArrayList;

/**
 * Created by ALiBH on 2/17/2017.
 */

public class DummyFragment extends Fragment {
    private View view;
    private String title;//String for tab title

    private static RecyclerView recyclerView;
    ArrayList<MenuItems> item;
    ArrayList<MenuItemsImage> imageItems;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dummy_fragment, container, false);
        Restaurant_Items items = (Restaurant_Items) getActivity();
        RestaurantsInfo rest = items.restaurant;
        int i = getArguments().getInt("ITEM");
        if(i>=0) {
            item = rest.getInfo().get(i).getItems();
            setRecyclerView();
        } else {
            imageItems = rest.getImageItems();
            setRecyclerView2();
        }
        return view;
    }
    //Setting recycler view
    private void setRecyclerView() {
        recyclerView = (RecyclerView) view.findViewById(R.id.item_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items
        ArrayList<Object> data = new ArrayList<>();
        data.addAll(item);
        GlobalAdapter adapter = new GlobalAdapter(getActivity(), data);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview
    }
    private void setRecyclerView2() {
        recyclerView = (RecyclerView) view.findViewById(R.id.item_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items
        ArrayList<Object> data = new ArrayList<>();
        data.addAll(imageItems);
        GlobalAdapter adapter = new GlobalAdapter(getActivity(), data);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview
    }
}
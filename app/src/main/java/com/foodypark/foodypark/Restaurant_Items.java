package com.foodypark.foodypark;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.foodypark.foodypark.restaurant.MenuInfo;
import com.foodypark.foodypark.restaurant.RestaurantsInfo;
import com.foodypark.foodypark.tablayout.DummyFragment;

import java.util.ArrayList;
import java.util.List;

import static com.foodypark.foodypark.R.id.tabLayout;
import static com.foodypark.foodypark.R.id.viewPager;

public class Restaurant_Items extends AppCompatActivity {
    Toolbar tb;
    private static ViewPager viewPager;
    private static TabLayout tabLayout;
    public RestaurantsInfo restaurant = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant__items);
        tb = (Toolbar) findViewById(R.id.restaurant_toolbar);
        Intent intent = getIntent();
        restaurant = intent.getParcelableExtra("NAME");
        Log.d("/*/*/*/",restaurant.getInfo().get(0).getMenuinfo());
        setUpToolbar(restaurant.getName());
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);//setting tab over viewpager

        //Implementing tab selected listener over tablayout
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());//setting current selected item over viewpager
                switch (tab.getPosition()) {
                    case 0:
                        Log.e("TAG","TAB1");
                        break;
                    case 1:
                        Log.e("TAG","TAB2");
                        break;
                    case 2:
                        Log.e("TAG","TAB3");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
    private void setUpToolbar(String name){
        tb.setTitle(name);
    }
    private void setupViewPager(ViewPager viewPager) {
        int y = -1;
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        Bundle bb = new Bundle();
        bb.putInt("ITEM",y++);

        DummyFragment obj = new DummyFragment();
        obj.setArguments(bb);
        adapter.addFrag(obj,"Recommended");

        for (MenuInfo x: restaurant.getInfo()){
            Bundle bundle = new Bundle();
            bundle.putInt("ITEM", y++);
            DummyFragment fragobj = new DummyFragment();
            fragobj.setArguments(bundle);
            adapter.addFrag(fragobj,x.getMenuinfo());
        }
        viewPager.setAdapter(adapter);
    }

    //View Pager fragments setting adapter class
    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();//fragment arraylist
        private final List<String> mFragmentTitleList = new ArrayList<>();//title arraylist

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        //adding fragments and title method
        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
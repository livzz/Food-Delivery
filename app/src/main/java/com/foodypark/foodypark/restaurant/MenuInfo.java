package com.foodypark.foodypark.restaurant;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by ALiBH on 2/17/2017.
 */

public class MenuInfo implements Parcelable{

    String menuinfo;
    ArrayList<MenuItems> items = new ArrayList<MenuItems>();

    public MenuInfo(String menuinfo, ArrayList<MenuItems> items) {
        this.menuinfo = menuinfo;
        this.items = items;
    }

    protected MenuInfo(Parcel in) {
        menuinfo = in.readString();
        items = in.createTypedArrayList(MenuItems.CREATOR);
    }

    public static final Creator<MenuInfo> CREATOR = new Creator<MenuInfo>() {
        @Override
        public MenuInfo createFromParcel(Parcel in) {
            return new MenuInfo(in);
        }

        @Override
        public MenuInfo[] newArray(int size) {
            return new MenuInfo[size];
        }
    };

    public String getMenuinfo() {
        return menuinfo;
    }

    public void setMenuinfo(String menuinfo) {
        this.menuinfo = menuinfo;
    }

    public ArrayList<MenuItems> getItems() {
        return items;
    }

    public void setItems(ArrayList<MenuItems> items) {
        this.items = items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(menuinfo);
        dest.writeTypedList(items);
    }
}

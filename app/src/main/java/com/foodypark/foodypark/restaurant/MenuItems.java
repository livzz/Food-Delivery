package com.foodypark.foodypark.restaurant;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ALiBH on 2/17/2017.
 */

public class MenuItems implements Parcelable {
    String item;
    int price;

    public MenuItems(String item, int price) {
        this.item = item;
        this.price = price;
    }

    protected MenuItems(Parcel in) {
        item = in.readString();
        price = in.readInt();
    }

    public static final Creator<MenuItems> CREATOR = new Creator<MenuItems>() {
        @Override
        public MenuItems createFromParcel(Parcel in) {
            return new MenuItems(in);
        }

        @Override
        public MenuItems[] newArray(int size) {
            return new MenuItems[size];
        }
    };

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(item);
        dest.writeInt(price);
    }
}

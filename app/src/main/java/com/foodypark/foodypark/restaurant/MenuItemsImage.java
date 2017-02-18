package com.foodypark.foodypark.restaurant;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ALiBH on 2/17/2017.
 */

public class MenuItemsImage implements Parcelable{
    String item;
    int price;
    String itemImage;

    public MenuItemsImage(String item, int price, String itemImage) {
        this.item = item;
        this.price = price;
        this.itemImage = itemImage;
    }

    protected MenuItemsImage(Parcel in) {
        item = in.readString();
        price = in.readInt();
        itemImage = in.readString();
    }

    public static final Creator<MenuItemsImage> CREATOR = new Creator<MenuItemsImage>() {
        @Override
        public MenuItemsImage createFromParcel(Parcel in) {
            return new MenuItemsImage(in);
        }

        @Override
        public MenuItemsImage[] newArray(int size) {
            return new MenuItemsImage[size];
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

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(item);
        dest.writeInt(price);
        dest.writeString(itemImage);
    }
}
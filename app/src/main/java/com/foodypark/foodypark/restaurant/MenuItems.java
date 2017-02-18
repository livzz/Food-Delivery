package com.foodypark.foodypark.restaurant;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ALiBH on 2/17/2017.
 */

public class MenuItems implements Parcelable {
    @SerializedName("Name")
    @Expose
    String item;
    @SerializedName("Price")
    @Expose
    int price;
    @SerializedName("Availability")
    @Expose
    private boolean availability;

    public MenuItems(String item, int price,boolean availability) {
        this.item = item;
        this.price = price;
        this.availability = availability;
    }


    protected MenuItems(Parcel in) {
        item = in.readString();
        price = in.readInt();
        availability = in.readByte() != 0;
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

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(item);
        dest.writeInt(price);
        dest.writeByte((byte) (availability ? 1 : 0));
    }
}

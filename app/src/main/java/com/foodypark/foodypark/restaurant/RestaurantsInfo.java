package com.foodypark.foodypark.restaurant;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ALiBH on 2/14/2017.
 */

public class RestaurantsInfo implements Parcelable {
    @SerializedName("location_name")
    @Expose
    private String locationName;
    @SerializedName("r_time")
    @Expose
    private String time;
    @SerializedName("r_name")
    @Expose
    private String name;
    @SerializedName("r_location")
    @Expose
    private String loc;
    @SerializedName("r_image")
    @Expose
    private String imageID;
    @SerializedName("r_date")
    @Expose
    private String date;
    @SerializedName("r_menu")
    @Expose
    private ArrayList<MenuInfo> info = new ArrayList<>();
    @SerializedName("r_menu_image")
    @Expose
    private ArrayList<MenuItemsImage> imageItems = new ArrayList<>();

    public RestaurantsInfo(String locationName,String time, String name, String loc, String imageID,String date, ArrayList<MenuInfo> info, ArrayList<MenuItemsImage> imageItems) {
        this.time = time;
        this.name = name;
        this.loc = loc;
        this.imageID = imageID;
        this.date = date;
        this.info = info;
        this.imageItems = imageItems;
        this.locationName = locationName;
    }

    protected RestaurantsInfo(Parcel in) {
        time = in.readString();
        name = in.readString();
        loc = in.readString();
        imageID = in.readString();
        date = in.readString();
        locationName = in.readString();
        info = in.createTypedArrayList(MenuInfo.CREATOR);
        imageItems = in.createTypedArrayList(MenuItemsImage.CREATOR);
    }

    public static final Creator<RestaurantsInfo> CREATOR = new Creator<RestaurantsInfo>() {
        @Override
        public RestaurantsInfo createFromParcel(Parcel in) {
            return new RestaurantsInfo(in);
        }

        @Override
        public RestaurantsInfo[] newArray(int size) {
            return new RestaurantsInfo[size];
        }
    };

    public ArrayList<MenuInfo> getInfo() {
        return info;
    }

    public void setInfo(ArrayList<MenuInfo> info) {
        this.info = info;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public ArrayList<MenuItemsImage> getImageItems() {
        return imageItems;
    }

    public void setImageItems(ArrayList<MenuItemsImage> imageItems) {
        this.imageItems = imageItems;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(time);
        dest.writeString(name);
        dest.writeString(loc);
        dest.writeString(imageID);
        dest.writeString(date);
        dest.writeTypedList(info);
        dest.writeString(locationName);
        dest.writeTypedList(imageItems);
    }
}
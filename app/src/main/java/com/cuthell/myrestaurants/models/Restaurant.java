package com.cuthell.myrestaurants.models;

import android.util.Log;

import org.parceler.Parcel;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcuthell on 10/17/2017.
 */
@Parcel
public class Restaurant {
    private String name;
    private String phone;
    private String website;
    private double rating;
    private String imageUrl;
    private List<String> address = new ArrayList<>();
    private double latitude;
    private double longitude;
    private List<String> categories = new ArrayList<>();
    private String pushId;

    public Restaurant(){

    }

    public Restaurant(String name, String phone, String website,
                      double rating, String imageUrl, ArrayList<String> address,
                      double latitude, double longitude, ArrayList<String> categories) {
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return  website;
    }

    public double getRating() {
        return rating;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public List<String> getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public List<String> getCategories() {
        return categories;
    }

    public String getLargeImageUrl(String imageUrl){
        String largeImageUrl = imageUrl.substring(0, imageUrl.length() - 6).concat("o.jpg");
        Log.d("TESTING", imageUrl);
        Log.d("TESTING", largeImageUrl);
        return largeImageUrl;
    }
    public String getPushId() {
        return pushId;
    }
    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}

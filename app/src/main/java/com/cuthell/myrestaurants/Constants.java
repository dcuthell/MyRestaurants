package com.cuthell.myrestaurants;

/**
 * Created by dcuthell on 10/17/2017.
 */

public class Constants {
    public static final String YELP_TOKEN = BuildConfig.YELP_TOKEN;
    public static final String YELP_BASE_URL = "https://api.yelp.com/v3/businesses/search?term=restaurants";
    public static final String YELP_LOCATION_QUERY_PARAMETER = "location";
    public static final String PREFERENCES_LOCATION_KEY = "location";
    public static final String FIREBASE_CHILD_SEARCHED_LOCATION = "searchedLocation";
    public static final String FIREBASE_CHILD_RESTAURANTS = "restaurants";
}

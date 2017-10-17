package com.cuthell.myrestaurants.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cuthell.myrestaurants.R;
import com.cuthell.myrestaurants.models.Restaurant;
import com.cuthell.myrestaurants.services.YelpService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RestaurantsActivity extends AppCompatActivity {

    @Bind(R.id.locationTextView) TextView mLocationTextView;
    @Bind(R.id.listView) ListView mListView;

    public ArrayList<Restaurant> restaurants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        mLocationTextView.setText("Here are all the restaurants near: " + location);
        Log.d("TESTING", "OKKAAYYYY1");
        getRestaurants(location);
        Log.d("TESTING", "OKKAAYYYY2");

    }

    private void getRestaurants(String location) {
        final YelpService yelpService = new YelpService();
        yelpService.findRestaurants(location, new Callback(){

            @Override
            public void onFailure(Call call, IOException e){
                Log.d("TESTING", "OKKAAYYYY3");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response){
                restaurants = yelpService.processResults(response);
                Log.d("TESTING", "OKKAAYYYY4");

                RestaurantsActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        Log.d("TESTING", "OKKAAYYYY");
                        String[] restaurantNames = new String[restaurants.size()];
                        for (int i = 0; i < restaurantNames.length; i++) {
                            restaurantNames[i] = restaurants.get(i).getName();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(RestaurantsActivity.this, android.R.layout.simple_list_item_1, restaurantNames);
                        mListView.setAdapter(adapter);

                        for (Restaurant restaurant : restaurants) {
                            Log.d("TESTING", "Name: " + restaurant.getName());
                            Log.d("TESTING", "Phone: " + restaurant.getPhone());
                            Log.d("TESTING", "Website: " + restaurant.getWebsite());
                            Log.d("TESTING", "Image url: " + restaurant.getImageUrl());
                            Log.d("TESTING", "Rating: " + Double.toString(restaurant.getRating()));
                            Log.d("TESTING", "Address: " + android.text.TextUtils.join(", ", restaurant.getAddress()));
                            Log.d("TESTING", "Categories: " + restaurant.getCategories().toString());
                        }
                    }
                });
            }

        });
        Log.d("TESTING", "OKKAAYYYY5");
    }
}

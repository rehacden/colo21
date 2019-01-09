package com.colo.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GoogleApiService {

    private static final String API_KEY = "AIzaSyDs5yeccWfb643FuMmFjzMiVY-LX-ncHpE";

    public LatLng getLocation(String address) throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();
        GeocodingResult[] results =  GeocodingApi.geocode(context, address).await();
        if (results.length > 0) {
            LatLng location = results[0].geometry.location;
            return location;
        }
        return null;
    }
}

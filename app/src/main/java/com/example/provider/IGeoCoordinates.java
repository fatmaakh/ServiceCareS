package com.example.provider;


import retrofit2.Call;
import retrofit2.http.Query;
import retrofit2.http.GET;

public interface IGeoCoordinates {

    @GET("maps/api/geocode/json")
    Call<String> getGeoCode(@Query("address") String address);

    @GET("maps/api/directions/json")
    Call<String> getDirections(@Query("origin") String origin , @Query("destination") String destination);
}

package com.informatics.b254safaris.googleplaceapi.rest_api;


import com.informatics.b254safaris.googleplaceapi.models.DetailResult;
import com.informatics.b254safaris.googleplaceapi.models.DistanceResult;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Mayank Gupta on 11-12-2017.
 */

public interface HospitalListClient {


    @GET("distancematrix/json")
    Call<DistanceResult> getHospitalDistances(@QueryMap Map<String, String> params);

    @GET("place/details/json")
    Call<DetailResult> getHospitalDetails(@QueryMap Map<String, String> params);
}

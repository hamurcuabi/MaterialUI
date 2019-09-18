package com.emrhmrc.flexablercvtest.depoQr.api;

import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.Box;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.Place;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiJsonPlaces {


    @GET("Places/GetPlaces")
    Call<List<Place>> getAll();

    @GET("Places/GetPlace/{id}")
    Call<Place> getById(@Path("id") int id);

    @POST("Places/PostPlace")
    Call<Place> post(@Body Box box);

    @DELETE("Places/DeletePlace/{id}")
    Call<Place> delete(@Path("id") int id);


}

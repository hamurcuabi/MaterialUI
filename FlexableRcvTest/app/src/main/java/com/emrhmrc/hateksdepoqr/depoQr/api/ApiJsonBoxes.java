package com.emrhmrc.hateksdepoqr.depoQr.api;

import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.Box;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiJsonBoxes {


    @GET("Boxes/GetBoxes")
    Call<List<Box>> getAll();

    @GET("Boxes/GetBox/{id}")
    Call<Box> getById(@Path("id") int id);

    @POST("Boxes/PostBox")
    Call<Box> post(@Body Box box);

    @DELETE("Boxes/DeleteBox/{id}")
    Call<Box> delete(@Path("id") int id);


}

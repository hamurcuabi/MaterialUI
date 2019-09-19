package com.emrhmrc.hateksdepoqr.depoQr.api;

import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.GeneratedBox;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiJsonGeneratedBoxes {


    @GET("GeneratedBoxes/GetGeneratedBoxes")
    Call<List<GeneratedBox>> getAll();

    @GET("GeneratedBoxes/GetGeneratedBox/{id}")
    Call<GeneratedBox> getById(@Path("id") int id);

    @POST("GeneratedBoxes/PostGeneratedBox")
    Call<GeneratedBox> post(@Body GeneratedBox box);

    @DELETE("GeneratedBoxes/DeleteGeneratedBox/{id}")
    Call<GeneratedBox> delete(@Path("id") int id);

    @PUT("GeneratedBoxes/PutGeneratedBox/{id}")
    Call<Void> put(@Path("id") int id,@Body GeneratedBox box);


}

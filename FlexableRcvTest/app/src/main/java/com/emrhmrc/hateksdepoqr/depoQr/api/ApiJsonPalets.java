package com.emrhmrc.hateksdepoqr.depoQr.api;

import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.Box;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.Palet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiJsonPalets {


    @GET("Palets/GetPalets")
    Call<List<Palet>> getAll();

    @GET("Palets/GetPalet/{id}")
    Call<Palet> getById(@Path("id") int id);

    @POST("Palets/PostPalet")
    Call<Palet> post(@Body Palet box);

    @DELETE("Palets/DeletePalet/{id}")
    Call<Palet> delete(@Path("id") int id);


}

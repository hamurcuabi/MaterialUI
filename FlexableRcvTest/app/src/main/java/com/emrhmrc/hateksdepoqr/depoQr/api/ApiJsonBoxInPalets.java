package com.emrhmrc.hateksdepoqr.depoQr.api;

import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.Box;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.BoxInPalet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiJsonBoxInPalets {


    @GET("BoxInPalets/GetBoxInPalets")
    Call<List<BoxInPalet>> getAll();

    @GET("BoxInPalets/GetBoxInPalet/{id}")
    Call<BoxInPalet> getById(@Path("id") int id);

    @POST("BoxInPalets/PostBoxInPalet")
    Call<BoxInPalet> post(@Body BoxInPalet box);

    @DELETE("BoxInPalets/DeleteBoxInPalet/{id}")
    Call<BoxInPalet> delete(@Path("id") int id);


}

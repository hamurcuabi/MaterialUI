package com.emrhmrc.hateksdepoqr.depoQr.api;

import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.ViewBoxInPalet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiJsonViewBoxInPalets {


    @GET("ViewBoxInPalets/GetViewBoxInPalets")
    Call<List<ViewBoxInPalet>> getAll();

    @GET("ViewBoxInPalets/GetViewBoxInPalet/{id}")
    Call<ViewBoxInPalet> getById(@Path("id") int id);


}

package com.emrhmrc.flexablercvtest.depoQr.api;

import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.ViewBoxInPalet;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.ViewProductInPalet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiJsonViewProductInPalets {

    @GET("ViewProductInPalets/GetViewProductInPalets")
    Call<List<ViewProductInPalet>> getAll();

    @GET("ViewProductInPalets/GetViewProductInPalet/{id}")
    Call<ViewProductInPalet> getById(@Path("id") int id);
}

package com.emrhmrc.flexablercvtest.depoQr.api;

import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.ViewBoxInPalet;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.ViewGeneratedPalet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiJsonViewGeneratedPalets {


    @GET("ViewGeneratedPalets/GetViewGeneratedPalets")
    Call<List<ViewGeneratedPalet>> getAll();

    @GET("ViewGeneratedPalets/GetViewGeneratedPalet/{id}")
    Call<ViewGeneratedPalet> getById(@Path("id") int id);


}

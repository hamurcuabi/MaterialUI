package com.emrhmrc.flexablercvtest.depoQr.api;

import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.Box;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.GeneratedPalet;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.Member;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiJsonGeneratedPalets {


    @GET("GeneratedPalets/GetGeneratedPalets")
    Call<List<GeneratedPalet>> getAll();

    @GET("GeneratedPalets/GetGeneratedPalet/{id}")
    Call<GeneratedPalet> getById(@Path("id") int id);

    @POST("GeneratedPalets/PutGeneratedPalet/{id}")
    Call<GeneratedPalet> post(@Body Box box);

    @DELETE("GeneratedPalets/PostGeneratedPalet")
    Call<GeneratedPalet> delete(@Path("id") int id);


}

package com.emrhmrc.hateksdepoqr.depoQr.api;

import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.ViewGeneratedBox;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiJsonViewGeneratedBoxes {


    @GET("ViewGeneratedBoxes/GetViewGeneratedBoxes")
    Call<List<ViewGeneratedBox>> getAll();

    @GET("ViewGeneratedBoxes/GetViewGeneratedBox/{id}")
    Call<ViewGeneratedBox> getById(@Path("id") int id);


}

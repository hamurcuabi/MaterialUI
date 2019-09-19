package com.emrhmrc.hateksdepoqr.depoQr.api;

import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.ViewProductInGeneratedBox;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiJsonViewProductInGeneratedBoxes {

    @GET("ViewProductInGeneratedBox/GetViewProductInGeneratedBoxes")
    Call<List<ViewProductInGeneratedBox>> getAll();


    @GET("ViewProductInGeneratedBoxes/GetViewProductInGeneratedBox/{id}")
    Call<ViewProductInGeneratedBox> getById(@Path("id") String id);


}

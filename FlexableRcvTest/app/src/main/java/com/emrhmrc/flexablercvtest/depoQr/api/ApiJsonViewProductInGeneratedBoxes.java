package com.emrhmrc.flexablercvtest.depoQr.api;

import com.emrhmrc.flexablercvtest.depoQr.model.Product;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.ViewProductInGeneratedBox;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiJsonViewProductInGeneratedBoxes {

    @GET("ViewProductInGeneratedBox/GetViewProductInGeneratedBoxes")
    Call<List<ViewProductInGeneratedBox>> getAll();


    @GET("ViewProductInGeneratedBoxes/GetViewProductInGeneratedBox/{id}")
    Call<ViewProductInGeneratedBox> getById(@Path("id") int id);


}

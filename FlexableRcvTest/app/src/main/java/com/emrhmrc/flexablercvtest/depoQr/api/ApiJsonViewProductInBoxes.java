package com.emrhmrc.flexablercvtest.depoQr.api;

import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.ViewProductInBox;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiJsonViewProductInBoxes {


    @GET("ViewProductInBoxes/GetViewProductInBoxes")
    Call<List<ViewProductInBox>> getAll();

    @GET("ViewProductInBoxes/GetViewProductInBox/{id}")
    Call<ViewProductInBox> getById(@Path("id") int id);


}

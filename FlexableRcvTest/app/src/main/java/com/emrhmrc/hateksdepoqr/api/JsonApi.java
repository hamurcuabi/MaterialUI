package com.emrhmrc.hateksdepoqr.api;


import com.emrhmrc.hateksdepoqr.depoQr.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApi {

    @GET("products/getproducts")
    Call<List<Product>> getTest();


}

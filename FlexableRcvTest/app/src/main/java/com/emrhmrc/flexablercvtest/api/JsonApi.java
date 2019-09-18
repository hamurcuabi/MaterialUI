package com.emrhmrc.flexablercvtest.api;


import com.emrhmrc.flexablercvtest.depoQr.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApi {

    @GET("products/getproducts")
    Call<List<Product>> getTest();


}

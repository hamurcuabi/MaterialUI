package com.emrhmrc.hateksdepoqr.depoQr.api;

import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.Box;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiJsonProducts {


    @GET("Products/GetProducts")
    Call<List<Product>> getAll();

    @GET("Products/GetProduct/{id}")
    Call<Product> getById(@Path("id") int id);

    @POST("Products/PostProduct")
    Call<Product> post(@Body Box box);

    @DELETE("Products/DeleteProduct/{id}")
    Call<Product> delete(@Path("id") int id);


}

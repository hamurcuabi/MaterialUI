package com.emrhmrc.hateksdepoqr.depoQr.api;

import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.ProductInBoxes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiJsonProductInBoxes {


    @GET("ProductInBoxes/GetProductInBoxes")
    Call<List<ProductInBoxes>> getAll();

    @GET("ProductInBoxes/GetProductInBox/{id}")
    Call<ProductInBoxes> getById(@Path("id") int id);

    @POST("ProductInBoxes/PostProductInBox")
    Call<ProductInBoxes> post(@Body ProductInBoxes box);

    @DELETE("ProductInBoxes/DeleteProductInBox/{id}")
    Call<ProductInBoxes> delete(@Path("id") int id);

    @POST("ProductInBoxes/PostProductInBoxToDelete")
    Call<ProductInBoxes> deleteWithBody(@Body ProductInBoxes box);


}

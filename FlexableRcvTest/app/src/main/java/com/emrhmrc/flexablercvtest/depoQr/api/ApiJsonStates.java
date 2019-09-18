package com.emrhmrc.flexablercvtest.depoQr.api;

import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.Box;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.State;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiJsonStates {


    @GET("States/GetStates")
    Call<List<State>> getAll();

    @GET("States/GetState/{id}")
    Call<State> getById(@Path("id") int id);

    @POST("States/PostState")
    Call<State> post(@Body Box box);

    @DELETE("States/DeleteState/{id}")
    Call<State> delete(@Path("id") int id);


}

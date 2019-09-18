package com.emrhmrc.flexablercvtest.depoQr.api;

import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.Box;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.Member;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiJsonMembers {


    @GET("Members/GetMembers")
    Call<List<Member>> getAll();

    @GET("Members/GetMember/{id}")
    Call<Member> getById(@Path("id") int id);

    @POST("Members/PostMember")
    Call<Member> post(@Body Box box);

    @DELETE("Members/DeleteMember/{id}")
    Call<Member> delete(@Path("id") int id);


}

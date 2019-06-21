package com.emrhmrc.depomodulapp.api;



import com.emrhmrc.depomodulapp.model.TestTable;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonApi {

    @GET("TestTables/{ID}")
    Call<TestTable> GetTable(@Path("ID") String id);


}

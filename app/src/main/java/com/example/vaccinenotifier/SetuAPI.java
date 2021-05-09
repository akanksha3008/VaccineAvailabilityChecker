package com.example.vaccinenotifier;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SetuAPI {

@GET("api/v2/admin/location/states")
    Call<AllStates> getStateList();
}

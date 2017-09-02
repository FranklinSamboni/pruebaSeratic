package com.example.frank.boletic.net;

import com.example.frank.boletic.models.Usuario;
import com.example.frank.boletic.net.response.MyResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by FRANK on 2/09/2017.
 */

public interface ApiInterface {

    @POST("/testSeratic/registerNewUser")
    Call<JsonObject> registerNewUser(@Body Usuario user);


    @POST("/testSeratic/validateLogin")
    Call<JsonObject> validateLogin(@Body JsonObject content);


    @Headers({"Content-Type: application/json"})
    @GET("/eventos/getAllEvents")
    Call<JsonObject> getAllEvents();


}

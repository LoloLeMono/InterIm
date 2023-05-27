package com.mobile.inter_im;

import com.mobile.inter_im.model.SendOfferData;
import com.mobile.inter_im.model.ResultData;
import com.mobile.inter_im.model.UserData;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @GET("/users")
    Call<List<UserData>> getUsers();
    @POST("/login")
    Call<ResultData> executeLogin(@Body UserData user);
    @POST("/find-offers")
    Call<List<SendOfferData>> executeOffer(@Body SendOfferData offer);
    @POST("signup")
    Call<Void> executeSignup(@Body HashMap<String, String> map);
}

package com.mobile.inter_im;

import com.mobile.inter_im.model.OfferData;
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
    Call<UserData> executeLogin(@Body UserData user);
    @POST("/find-offers")
    Call<List<OfferData>> executeOffer(@Body OfferData offer);
    @POST("/signup")
    Call<ResultData> executeSignup(@Body UserData user);
}

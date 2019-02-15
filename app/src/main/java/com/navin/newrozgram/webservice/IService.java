package com.navin.newrozgram.webservice;


import com.navin.newrozgram.models.Posts;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IService<T> {


    @FormUrlEncoded
    @POST("posts.php")
    Call<List<Posts>> getAllPosts(@Field("from") int from, @Field("to") int to );


    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> login(@Field("username") String username, @Field("password") String password );

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> register(@Field("username") String username, @Field("password") String password );



}

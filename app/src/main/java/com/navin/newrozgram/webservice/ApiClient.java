package com.navin.newrozgram.webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit retrofit = null;
    public static final String BASE_URL = "http://androidsupport.ir/picpic/";
    public static final String BASE_URL_IMAGES = BASE_URL+"images/";

    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();

        }

        return retrofit;

    }
}

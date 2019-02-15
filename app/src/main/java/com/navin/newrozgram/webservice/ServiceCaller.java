package com.navin.newrozgram.webservice;


import com.navin.newrozgram.models.IMessageListener;
import com.navin.newrozgram.models.Posts;
import com.navin.newrozgram.models.User;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceCaller {


    IService iService;

    public ServiceCaller(){
        iService= ApiClient.getClient().create(IService.class);
    }



    public void getAllPosts(int from , int to, IMessageListener iMessageListener){

        Call<List<Posts>> call = iService.getAllPosts(from,to);


        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                iMessageListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                iMessageListener.onFail(t.getMessage().toString() + "");
            }
        });



    }

    public void login(User user, IMessageListener iMessageListener){

        Call<ResponseBody> call = iService.login(user.getUsername(),user.getPassword());


        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    iMessageListener.onSuccess(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            iMessageListener.onFail(t.getMessage().toString()+"");
            }
        });


    }





}

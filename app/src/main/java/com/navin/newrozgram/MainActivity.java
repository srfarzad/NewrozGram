package com.navin.newrozgram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.navin.androidframework.ui.BaseActivity;
import com.navin.newrozgram.models.IMessageListener;
import com.navin.newrozgram.webservice.ServiceCaller;

public class MainActivity extends BaseActivity {


    ServiceCaller serviceCaller;

    @Override
    public int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        serviceCaller = new ServiceCaller();

        serviceCaller.getAllPosts(0, 10, new IMessageListener() {
            @Override
            public void onSuccess(Object response) {

            }

            @Override
            public void onFail(String errorResponse) {

            }
        });




    }


}

package com.navin.newrozgram.ui.login;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.navin.newrozgram.MainActivity;
import com.navin.newrozgram.R;
import com.navin.newrozgram.models.IMessageListener;
import com.navin.newrozgram.models.User;
import com.navin.newrozgram.webservice.DataParser;
import com.navin.newrozgram.webservice.ServiceCaller;

public class LoginInteractor {


    public interface iLoginListener {


        public void onError();

        public void onResponse(String response);

        public void onUsernameError();

        public void onPasswordError();

    }

    public void login(String username, String password, iLoginListener iLoginListener) {


        if (username.isEmpty()) {
            iLoginListener.onUsernameError();
            return;
        }
        if (password.isEmpty()) {
            iLoginListener.onPasswordError();
            return;
        }


        ServiceCaller serviceCaller = new ServiceCaller();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        serviceCaller.login(user, new IMessageListener() {
            @Override
            public void onSuccess(Object response) {

                String res = response.toString().substring(1, response.toString().length());
                iLoginListener.onResponse(res);


            }

            @Override
            public void onFail(String errorResponse) {
                iLoginListener.onError();

            }
        });


    }


}

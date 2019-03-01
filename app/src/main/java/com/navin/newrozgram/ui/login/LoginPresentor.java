package com.navin.newrozgram.ui.login;

import android.content.Context;

import com.navin.androidframework.utility.NetworkState;
import com.navin.newrozgram.config.AppSetting;
import com.navin.newrozgram.models.User;
import com.navin.newrozgram.webservice.DataParser;

public class LoginPresentor implements LoginInteractor.iLoginListener {


    LoginView loginView;
    LoginInteractor loginInteractor;
    AppSetting appSetting;
    String username, password;
    Context context;

    public LoginPresentor(Context context, LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
        appSetting = new AppSetting(context);
        this.context = context;
    }


    public void validateLogin(String username, String password) {

        this.username = username;
        this.password = password;
        if (loginView != null) {

            loginView.showProgressBar();


            if(NetworkState.isConnectionAvailable(context)) {
                loginInteractor.login(username, password, this);
            }
            else  {
                loginView.hideProgressBar();
                loginView.connectionChecker();
            }




        }


    }


    @Override
    public void onError() {

        if (loginView != null) {

            loginView.hideProgressBar();


        }

    }

    @Override
    public void onResponse(String response) {

        if (loginView != null) {
            loginView.hideProgressBar();

            try {
                int code = Integer.parseInt(DataParser.parseJson(response.toString()));

                if (code <= 0) {
                    loginView.onError();
                } else {
                    loginView.navigateToHome();
                    appSetting.SetId(code);
                    User user = new User();
                    user.setPassword(password);
                    user.setUsername(username);
                    appSetting.saveData(user);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }

    @Override
    public void onUsernameError() {

        if (loginView != null) {
            loginView.hideProgressBar();
            loginView.errorUsername();

        }

    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.hideProgressBar();
            loginView.errorPassword();

        }

    }
}

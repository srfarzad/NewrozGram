package com.navin.newrozgram.ui.login;

public interface LoginView {

    public void errorUsername();

    public void errorPassword();

    public void showProgressBar();

    public void hideProgressBar();

    public void connectionChecker();

    public void navigateToHome();

    public void onError();


}

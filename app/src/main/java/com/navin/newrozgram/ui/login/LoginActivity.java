package com.navin.newrozgram.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.BindView;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.android.material.snackbar.Snackbar;
import com.navin.androidframework.ui.BaseActivity;
import com.navin.androidframework.utility.ApplicationManager;
import com.navin.newrozgram.MainActivity;
import com.navin.newrozgram.R;
import com.navin.newrozgram.config.AppSetting;
import com.navin.newrozgram.config.Permission;
import com.navin.newrozgram.models.IMessageListener;
import com.navin.newrozgram.models.User;
import com.navin.newrozgram.service.MediaPlayerService;
import com.navin.newrozgram.ui.register.RegisterActivity;
import com.navin.newrozgram.webservice.DataParser;
import com.navin.newrozgram.webservice.ServiceCaller;

public class LoginActivity extends BaseActivity implements LoginView {


    @BindView(R.id.input_email)
    AppCompatEditText input_email;
    @BindView(R.id.input_password)
    AppCompatEditText input_password;
    @BindView(R.id.btn_login)
    AppCompatButton btn_login;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    ServiceCaller serviceCaller;
    AppSetting appSetting;
    LoginPresentor loginPresentor;


    //@BindView(R.id.link_signup) AppCompatTextView link_signup;

    @BindView(R.id.rel_main) RelativeLayout rel_main;

    @Override
    public int setContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        serviceCaller
                = new ServiceCaller();
        appSetting = new AppSetting(getApplicationContext());


        if (appSetting.getId() > 0) {
            finish();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
           // startActivity(intent);
        }


        loginPresentor = new LoginPresentor(getApplicationContext(), this, new LoginInteractor());


        Permission.checkPermission(LoginActivity.this);


    }


    @OnClick(R.id.btn_login)
    public void btn_login_click(View view) {

        loginPresentor.validateLogin(input_email.getText().toString(), input_password.getText().toString());
    }

    @OnClick(R.id.link_signup)
    public void link_signup_click() {
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
    }


    @Override
    public void errorUsername() {
        input_email.setError(getString(R.string.username_required));
    }

    @Override
    public void errorPassword() {
        input_password.setError(getString(R.string.password_required));
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void connectionChecker() {

        Snackbar.make(rel_main,getString(R.string.check_connection),Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void navigateToHome() {

        finish();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);


        if(ApplicationManager.isMyServiceRunning(getApplicationContext(),MediaPlayerService.class)) {
            Intent intent1= new Intent(getApplicationContext(), MediaPlayerService.class);
            startService(intent1);
        }




    }

    @Override
    public void onError() {
        progressBar.setVisibility(View.GONE);
        Snackbar.make(rel_main,getString(R.string.check_connection),Snackbar.LENGTH_LONG).show();
    }
}

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

import com.google.android.material.snackbar.Snackbar;
import com.navin.androidframework.ui.BaseActivity;
import com.navin.newrozgram.MainActivity;
import com.navin.newrozgram.R;
import com.navin.newrozgram.models.IMessageListener;
import com.navin.newrozgram.models.User;
import com.navin.newrozgram.webservice.DataParser;
import com.navin.newrozgram.webservice.ServiceCaller;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.input_email) AppCompatEditText input_email;
    @BindView(R.id.input_password) AppCompatEditText input_password;
    @BindView(R.id.btn_login) AppCompatButton btn_login;
    @BindView(R.id.progressBar) ProgressBar progressBar;

    ServiceCaller serviceCaller;

    @Override
    public int setContentView() {
        return R.layout.activity_login;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serviceCaller
                 = new ServiceCaller();




    }


    @OnClick(R.id.btn_login)
    public void btn_login_click(View view){


        login(view);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

     //   startActivity(intent);



    }


    private void login(View v){

        progressBar.setVisibility(View.VISIBLE);

        User user = new User();
        user.setUsername(input_email.getText().toString());
        user.setPassword(input_password.getText().toString());
        serviceCaller.login(user, new IMessageListener() {
            @Override
            public void onSuccess(Object response) {

                progressBar.setVisibility(View.GONE);

                String res = response.toString().substring(1,response.toString().length());

                try {
                    int code  = Integer.parseInt( DataParser.parseJson(response.toString()));

                    if(code>0) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                        startActivity(intent);

                    }
                    else  {
                        Snackbar.make(v,getString(R.string.error_login),Snackbar.LENGTH_LONG).show();
                    }


                    Log.e("Code",code+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFail(String errorResponse) {
                progressBar.setVisibility(View.GONE);

            }
        });


    }





}

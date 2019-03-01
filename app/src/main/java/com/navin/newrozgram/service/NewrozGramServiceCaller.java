package com.navin.newrozgram.service;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;

import com.navin.newrozgram.NewrozService;
import com.navin.newrozgram.ui.register.RegisterActivity;

import androidx.annotation.Nullable;

public class NewrozGramServiceCaller  extends Service {




    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return newrozService;
    }


    public NewrozService.Stub newrozService = new NewrozService.Stub() {
        @Override
        public void login(String username, String password) throws RemoteException {

        }

        @Override
        public void register() throws RemoteException {

            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);

        }

        @Override
        public void pay(String cost) throws RemoteException {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
            startActivity(intent);
        }
    };


}

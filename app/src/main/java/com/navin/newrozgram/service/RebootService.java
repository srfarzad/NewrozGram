package com.navin.newrozgram.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class RebootService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"Rebbot Newroz Gram",Toast.LENGTH_LONG).show();
    }
}

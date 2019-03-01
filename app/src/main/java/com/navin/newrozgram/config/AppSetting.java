package com.navin.newrozgram.config;

import android.content.Context;
import android.content.SharedPreferences;

import com.navin.newrozgram.models.User;

public class AppSetting {

    public static String KEY_USERNAME = "username";
    public static String KEY_PASSWORD = "password";
    public static String KEY_ID = "id";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public AppSetting(Context context) {
        sharedPreferences = context.getSharedPreferences("AppSetting", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveData(User user) {
        editor.putString(KEY_USERNAME, user.getUsername());
        editor.putString(KEY_PASSWORD, user.getUsername());
        editor.commit();
    }

    public String getUsername() {
        return sharedPreferences.getString(KEY_USERNAME, "");
    }

    public String getPassword() {
        return sharedPreferences.getString(KEY_PASSWORD, "");
    }


    public void SetId(int id){

        editor.putInt(KEY_ID,id);
        editor.commit();
    }

    public int getId(){
        return sharedPreferences.getInt(KEY_ID,0);
    }


}

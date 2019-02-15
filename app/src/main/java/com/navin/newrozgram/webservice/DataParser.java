package com.navin.newrozgram.webservice;


import org.json.JSONObject;

public class DataParser {


    public static String parseJson(String response) throws Exception {

        JSONObject jsonObject = new JSONObject(response);

        String code = jsonObject.getString("code");


        return code;
    }
}

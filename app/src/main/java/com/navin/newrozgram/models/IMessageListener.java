package com.navin.newrozgram.models;

public interface IMessageListener<T> {

    public void onSuccess(T response);
    public void onFail(String errorResponse);
}

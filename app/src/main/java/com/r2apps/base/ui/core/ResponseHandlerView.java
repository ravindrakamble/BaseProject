package com.r2apps.base.ui.core;

/**
 * Created by user on 7/12/2016.
 */
public interface ResponseHandlerView {
    //void sendRequest();

    void onResponse(byte requestCode, Object response);
    void onFailure(byte requestCode, byte responseCode, String message);
}

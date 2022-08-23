package com.qxy.wltyVideo.models;

import java.io.Serializable;

public class ClientTokenResponse implements Serializable {
    //数据
    private ClientTokenData data;
    //数据
    private String message;

    public ClientTokenData getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}

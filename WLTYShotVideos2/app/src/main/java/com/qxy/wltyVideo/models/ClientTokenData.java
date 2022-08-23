package com.qxy.wltyVideo.models;

import java.io.Serializable;

public class ClientTokenData implements Serializable {
    private  int expires_in;//	access_token接口调用凭证超时时间，单位（秒	7200
    private  String access_token;//		接口调用凭证	access_token
    private  String description;//	错误码描述
    private  String error_code;//	错误码
    private  String captcha;
    private  String desc_url;
    private  String log_id;

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }
}

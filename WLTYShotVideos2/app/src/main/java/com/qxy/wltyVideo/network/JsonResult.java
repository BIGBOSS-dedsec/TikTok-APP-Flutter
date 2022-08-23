package com.qxy.wltyVideo.network;

import java.io.Serializable;

/**
 * 服务端返回结果基础类
 *
 * @param <T>
 */

public class JsonResult<T> implements Serializable {
    //数据
    private T data;
    //数据
    private String message;

    public T getData() {
        return data;
    }
}

package com.xcz.baselib.utils;

/**
 * desc: eventBus发送的消息
 * Created by xcz
 * on 2018/7/6.
 */
public class BaseEvent {
    private int requestTag;
    private Object data;

    public int getRequestTag() {
        return requestTag;
    }

    public void setRequestTag(int requestTag) {
        this.requestTag = requestTag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

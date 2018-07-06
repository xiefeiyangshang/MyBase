package com.xcz.baselib.utils;

import org.greenrobot.eventbus.EventBus;

/**
 * desc:EventBus事件总线工具类
 * Created by xcz
 * on 2018/7/6.
 */
public class EventBusUtils {

    public EventBusUtils() {
    }

    /**
     * 取消订阅
     */
    public static void unregister(BaseEvent subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    /**
     * 订阅事件
     */
    public static void register(BaseEvent subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    /**
     * 发送事件
     */
    public static void post(BaseEvent event) {
        EventBus.getDefault().post(event);
    }

}

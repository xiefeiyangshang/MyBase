package com.xcz.baselib.utils.thread;

import android.support.annotation.NonNull;

import java.util.concurrent.ThreadFactory;

/**
 * desc:默认Thread工厂
 * Created by xcz
 * on 2018/5/16.
 */
public class MyThreadFactory implements ThreadFactory {

    private int priority;

    public MyThreadFactory(int priority) {
        this.priority = priority;
    }


    @Override
    public Thread newThread(@NonNull Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(priority);
        return thread;
    }

}

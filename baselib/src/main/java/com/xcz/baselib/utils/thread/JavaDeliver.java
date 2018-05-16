package com.xcz.baselib.utils.thread;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

/**
 * desc:默认情况下，用于Java平台的交付。
 * Created by xcz
 * on 2018/5/16.
 */
public class JavaDeliver implements Executor {

    private static JavaDeliver instance = new JavaDeliver();

    public static JavaDeliver getInstance() {
        return instance;
    }

    /**
     * 注意增加非空判断
     *
     * @param runnable runnable
     */
    @Override
    public void execute(@NonNull Runnable runnable) {
        runnable.run();
    }


}
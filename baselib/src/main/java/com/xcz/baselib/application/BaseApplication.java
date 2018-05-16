package com.xcz.baselib.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.xcz.baselib.utils.Utils;
import com.xcz.baselib.utils.thread.LogCallback;
import com.xcz.baselib.utils.thread.PoolThread;

/**
 * 基类Application
 * Created by xcz
 * on 2018/5/15.
 */
public class BaseApplication extends Application {


    private static BaseApplication instance;
    private PoolThread executor;

    public static synchronized BaseApplication getInstance() {
        if (null == instance) {
            instance = new BaseApplication();
        }
        return instance;
    }

    public BaseApplication() {
    }

    /**
     * 这个最先执行
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    /**
     * 程序启动的时候执行
     */
    @Override
    public void onCreate() {
        Log.d("Application", "onCreate");
        super.onCreate();
        instance = this;
        Utils.init(this);
        BaseLifecycleCallback.getInstance().init(this);
        initThreadPool();

    }


    /**
     * 程序终止的时候执行
     */
    @Override
    public void onTerminate() {
        Log.d("Application", "onTerminate");
        super.onTerminate();
    }


    /**
     * 低内存的时候执行
     */
    @Override
    public void onLowMemory() {
        Log.d("Application", "onLowMemory");
        super.onLowMemory();
    }


    /**
     * HOME键退出应用程序
     * 程序在内存清理的时候执行
     */
    @Override
    public void onTrimMemory(int level) {
        Log.d("Application", "onTrimMemory");
        super.onTrimMemory(level);
    }


    /**
     * onConfigurationChanged
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d("Application", "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }


    /**
     * 初始化线程池管理器
     */
    private void initThreadPool() {
        // 创建一个独立的实例进行使用
        executor = PoolThread.ThreadBuilder
                .createFixed(4)
                .setPriority(Thread.MAX_PRIORITY)
                .setCallback(new LogCallback())
                .build();
    }

    /**
     * 获取线程池管理器对象，统一的管理器维护所有的线程池
     *
     * @return executor对象
     */
    public PoolThread getExecutor() {
        return executor;
    }

}

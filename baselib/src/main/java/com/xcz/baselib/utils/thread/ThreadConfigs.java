package com.xcz.baselib.utils.thread;

import java.util.concurrent.Executor;

/**
 * desc:存储当前任务的某些配置
 * Created by xcz
 * on 2018/5/16.
 */
public final class ThreadConfigs {
    /**
     * 线程的名称
     * 通过setName方法设置
     */
    public String name;
    /**
     * 线程执行延迟的时间
     * 通过setDelay方法设置
     */
    public long delay;
    /**
     * 线程执行者
     * JAVA或者ANDROID
     */
    public Executor deliver;
    /**
     * 用户任务的状态回调callback
     */
    public ThreadCallback callback;
    /**
     * 异步callback回调callback
     */
    public AsyncCallback asyncCallback;
}

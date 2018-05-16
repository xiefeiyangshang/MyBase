package com.xcz.baselib.utils.thread;

import java.util.concurrent.Callable;

/**
 * desc: CallableWrapper
 * Created by xcz
 * on 2018/5/16.
 */
public final class CallableWrapper<T> implements Callable<T> {

    private String name;
    private ThreadCallback callback;
    private Callable<T> proxy;

    /**
     * 构造方法
     *
     * @param configs thread配置，主要参数有：线程name，延迟time，回调callback，异步callback
     * @param proxy   线程优先级
     */
    public CallableWrapper(ThreadConfigs configs, Callable<T> proxy) {
        this.name = configs.name;
        this.proxy = proxy;
        this.callback = new NormalCallback(configs.callback, configs.deliver, configs.asyncCallback);
    }

    /**
     * 详细可以看我的GitHub：https://github.com/yangchong211
     * 自定义Callable继承Callable<T>类，Callable 是在 JDK1.5 增加的。
     * Callable 的 call() 方法可以返回值和抛出异常
     *
     * @return 泛型
     * @throws Exception 异常
     */
    @Override
    public T call() {
        ThreadToolUtils.resetThread(Thread.currentThread(), name, callback);
        if (callback != null) {
            //开始
            callback.onStart(name);
        }
        T t = null;
        try {
            t = proxy == null ? null : proxy.call();
        } catch (Exception e) {
            e.printStackTrace();
            //异常错误
            if (callback != null) {
                callback.onError(name, e);
            }
        } finally {
            //完成
            if (callback != null) {
                callback.onCompleted(name);
            }
        }
        return t;
    }


}


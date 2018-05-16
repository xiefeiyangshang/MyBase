package com.xcz.baselib.utils.thread;

import java.util.concurrent.Callable;

/**
 * desc:
 * Created by xcz
 * on 2018/5/16.
 */
public final class RunnableWrapper implements Runnable {

    private String name;
    private NormalCallback normal;
    private Runnable runnable;
    private Callable callable;

    public RunnableWrapper(ThreadConfigs configs) {
        this.name = configs.name;
        this.normal = new NormalCallback(configs.callback, configs.deliver, configs.asyncCallback);
    }

    /**
     * 启动异步任务，普通的
     * @param runnable              runnable
     * @return                      对象
     */
    public RunnableWrapper setRunnable(Runnable runnable) {
        this.runnable = runnable;
        return this;
    }

    /**
     * 异步任务，回调用于接收可调用任务的结果
     * @param callable              callable
     * @return                      对象
     */
    public RunnableWrapper setCallable(Callable callable) {
        this.callable = callable;
        return this;
    }

    /**
     * 自定义xxRunnable继承Runnable，实现run方法
     * 详细可以看我的GitHub：https://github.com/yangchong211
     */
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        ThreadToolUtils.resetThread(current, name, normal);
        //开始
        normal.onStart(name);
        //注意需要判断runnable，callable非空
        // avoid NullPointException
        if (runnable != null) {
            runnable.run();
        } else if (callable != null) {
            try {
                Object result = callable.call();
                //监听成功
                normal.onSuccess(result);
            } catch (Exception e) {
                //监听异常
                normal.onError(name, e);
            }
        }
        //监听完成
        normal.onCompleted(name);
    }


}

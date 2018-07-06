package com.xcz.baselib.net;

import io.reactivex.disposables.Disposable;

/**
 * desc:
 * Created by xcz
 * on 2018/7/6.
 */
public abstract class NetSubscription<T> implements io.reactivex.Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {
        //添加订阅关系
        OnDisposable(d);
    }

    @Override
    public void onNext(T t) {
        OnSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        //自定义异常的传递
        OnFail(ExceptionHandle.handleException(e));
    }

    @Override
    public void onComplete() {
        OnCompleted();
    }

    public abstract void OnSuccess(T t);

    public abstract void OnFail(ExceptionHandle.ResponeThrowable e);

    public abstract void OnCompleted();

    public abstract void OnDisposable(Disposable d);
}

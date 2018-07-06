package com.xcz.baselib.mvp;

import io.reactivex.disposables.Disposable;

/**
 * desc:
 * Created by xcz
 * on 2018/7/6.
 */
public interface RxCallControHelp<T> {
    void add(Disposable disposable);

    void cancel(Disposable disposable);

    void cancelAll();
}

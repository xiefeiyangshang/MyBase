package com.xcz.baselib.mvp;

import io.reactivex.disposables.Disposable;

/**
 * 父类
 * Created by xcz
 * on 2018/5/15.
 */
public abstract class BasePresenter<T extends BaseMvpView> {
    protected T mView;
    protected RXCallController callController;

    public BasePresenter(T mView) {
        this.mView = mView;
        if (callController == null) {
            callController = new RXCallController();
        }
    }

    /**
     * 取消请求，分离mvp避免内存泄露
     */
    public void detach() {
        if (mView != null) {
            mView = null;
        }
        if (callController != null) {
            callController.cancelAll();
        }
    }

    /**
     * 添加请求至队列
     *
     * @param d
     */
    public void addDisposable(Disposable d) {
        if (callController != null) {
            callController.add(d);
        }
    }

    /**
     * 移除单个请求
     */
    public void cancelDisposable(Disposable d) {
        if (callController != null) {
            callController.cancel(d);
        }
    }
}

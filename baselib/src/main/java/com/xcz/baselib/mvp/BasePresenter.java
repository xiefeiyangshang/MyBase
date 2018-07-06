package com.xcz.baselib.mvp;

/**
 * 父类
 * Created by xcz
 * on 2018/5/15.
 */
public abstract class BasePresenter<T extends BaseMvpView> {
    protected T mView;

    public BasePresenter(T mView) {
        this.mView = mView;
    }

}

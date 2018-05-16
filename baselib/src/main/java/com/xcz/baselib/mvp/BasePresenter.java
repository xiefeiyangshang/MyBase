package com.xcz.baselib.mvp;

/**
 * 父类
 * Created by xcz
 * on 2018/5/15.
 */
public interface BasePresenter {
    //绑定数据
    void subscribe();

    //解除绑定
    void unSubscribe();
}

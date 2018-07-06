package com.xcz.baselib.mvp;

import android.content.Context;

/**
 * Created by xcz
 * on 2018/5/15.
 */
public interface BaseMvpView {
    void showMessage(String message);

    void startLoading();

    void stopLoading();

    void noData();

    void noNetWork();

    Context getActivityContext();
}

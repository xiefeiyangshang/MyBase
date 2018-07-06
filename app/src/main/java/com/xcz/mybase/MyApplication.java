package com.xcz.mybase;

import com.xcz.baselib.application.BaseApplication;
import com.xcz.mybase.config.Constans;

/**
 * desc:
 * Created by xcz
 * on 2018/5/18.
 */
public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Constans.HOST = Constans.HOST_ONLINE;
        }

    }
}

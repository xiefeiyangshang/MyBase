package com.xcz.mybase.splash.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xcz.baselib.activity.BaseActivity;
import com.xcz.baselib.utils.bar.AppBar;
import com.xcz.baselib.utils.sp.SPUtils;
import com.xcz.mybase.MyConfigs;
import com.xcz.mybase.R;

/**
 * desc: 欢迎页面
 * Created by xcz
 * on 2018/5/18.
 */
public class SplashActivity extends BaseActivity {


    @Override
    public int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppBar.translucentStatusBar(this, true);
    }

    @Override
    public void initView() {
        if (SPUtils.getInstance(MyConfigs.SP_NAME).getBoolean(MyConfigs.FIRST_SPLASH, true)) {
            initBanner();
        } else {

        }
    }

    private void initBanner() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }
}

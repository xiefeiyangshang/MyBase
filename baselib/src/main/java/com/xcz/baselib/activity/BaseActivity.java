package com.xcz.baselib.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xcz.baselib.R;
import com.xcz.baselib.mvp.BaseMvpView;
import com.xcz.baselib.mvp.BasePresenter;
import com.xcz.baselib.mvp.RXCallController;
import com.xcz.baselib.net.NetworkUtils;
import com.xcz.baselib.utils.BaseAppUtils;
import com.xcz.baselib.utils.ToastUtils;
import com.xcz.baselib.utils.bar.AppBar;
import com.xcz.baselib.weight.LoadingDialog;

import butterknife.ButterKnife;

/**
 * activity父类
 * Created by xcz
 * on 2018/5/15.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseMvpView {
    /**
     * 将代理类通用行为抽出来
     */
    protected T mPresenter;
    protected boolean needBackExit = false;
    protected Context mContext;
    protected LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        mContext = this;
        loadingDialog = new LoadingDialog(this);
        ButterKnife.bind(this);
        //避免切换横竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mPresenter = createPresenter();
        AppBar.setStatusBarColor(this, R.color.colorTheme);
        initView();
        initListener();
        initData();
        if (!NetworkUtils.isConnected()) {
            ToastUtils.showShort("请检查网络是否连接");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //测试内存泄漏，正式一定要隐藏
        initLeakCanary();
        if (mPresenter != null) {
            mPresenter.detach();
        }
    }


    /**
     * 返回一个用于显示界面的布局id
     *
     * @return 视图id
     */
    public abstract int getContentView();

    /**
     * 初始化View的代码写在这个方法中
     */
    public abstract void initView();

    /**
     * 初始化监听器的代码写在这个方法中
     */
    public abstract void initListener();

    /**
     * 初始数据的代码写在这个方法中，用于从服务器获取数据
     */
    public abstract void initData();

    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    @Override
    public Context getActivityContext() {
        return mContext;
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 用来检测所有Activity的内存泄漏
     */
    private void initLeakCanary() {
//        RefWatcher refWatcher = BaseApplication.getRefWatcher(this);
//        refWatcher.watch(this);
    }

    @Override
    public void onBackPressed() {
        if (needBackExit) {
            if (BaseAppUtils.exitApp()) {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }

    protected abstract T createPresenter();

    @Override
    public void startLoading() {
        if (loadingDialog != null && !loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    @Override
    public void stopLoading() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public void showMessage(String message) {
        ToastUtils.showShort(message);
    }

    @Override
    public void noData() {

    }

    @Override
    public void noNetWork() {

    }
}

package com.xcz.mybase.test.mvp;

import com.xcz.baselib.mvp.BasePresenter;
import com.xcz.baselib.mvp.RXCallController;
import com.xcz.baselib.net.ExceptionHandle;
import com.xcz.baselib.net.Observer;
import com.xcz.mybase.net.RetrofitManager;
import com.xcz.mybase.test.bean.WeatherBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * desc:
 * Created by xcz
 * on 2018/7/6.
 */
public class TestPresenter extends BasePresenter<TestView> {

    public TestPresenter(TestView mView) {
        super(mView);
    }

    public void getTQData(String cityName) {
        RetrofitManager.getSingleton().getTestRetrofit().getWeather(cityName, "json", 1, "4f1ec0b03630e509e23c9f4ad1bbf61a")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherBean>() {
                    @Override
                    public void OnSuccess(WeatherBean weatherBean) {
                        mView.getDataSu(weatherBean);
                    }

                    @Override
                    public void OnFail(ExceptionHandle.ResponeThrowable e) {
                    }

                    @Override
                    public void OnCompleted() {
                        mView.stopLoading();
                    }

                    @Override
                    public void OnDisposable(Disposable d) {
                        mView.startLoading();
                        RXCallController.getInstanceRx().add(d);
                    }
                });

    }
}

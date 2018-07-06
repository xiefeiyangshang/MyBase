package com.xcz.mybase.test.activity;

import android.widget.TextView;

import com.xcz.baselib.activity.BaseActivity;
import com.xcz.mybase.R;
import com.xcz.mybase.test.bean.WeatherBean;
import com.xcz.mybase.test.mvp.TestPresenter;
import com.xcz.mybase.test.mvp.TestView;

import butterknife.BindView;

/**
 * desc:
 * Created by xcz
 * on 2018/7/6.
 */
public class TestActivity extends BaseActivity<TestPresenter> implements TestView {

    @BindView(R.id.tv_test)
    TextView text;

    @Override
    public int getContentView() {
        return R.layout.test_activity;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        mPresenter.getTQData("北京");
    }

    @Override
    protected TestPresenter createPresenter() {
        return new TestPresenter(this);
    }

    @Override
    public void getDataSu(WeatherBean weatherBean) {
        text.setText(weatherBean.toString());
    }
}

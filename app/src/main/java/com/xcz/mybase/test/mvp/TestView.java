package com.xcz.mybase.test.mvp;

import com.xcz.baselib.mvp.BaseMvpView;
import com.xcz.mybase.test.bean.ResultBean;

/**
 * desc:
 * Created by xcz
 * on 2018/7/6.
 */
public interface TestView extends BaseMvpView {
    void getDataSu(ResultBean weatherBean);
}

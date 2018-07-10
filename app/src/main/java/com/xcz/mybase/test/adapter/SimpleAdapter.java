package com.xcz.mybase.test.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xcz.mybase.R;
import com.xcz.mybase.test.bean.ResultBean;

import java.util.List;

/**
 * desc:
 * Created by xcz
 * on 2018/7/9.
 */
public class SimpleAdapter extends BaseQuickAdapter<ResultBean, SimpleVH> {

    public SimpleAdapter(@Nullable List<ResultBean> data) {
        super(R.layout.item_simple, data);
    }

    @Override
    protected void convert(SimpleVH helper, ResultBean item) {
        helper.setText(R.id.tv_city, item.getToday().getCity());
        helper.setText(R.id.tv_tem, item.getToday().getTemperature());
        helper.setText(R.id.tv_su, item.getToday().getDressing_advice());
    }
}

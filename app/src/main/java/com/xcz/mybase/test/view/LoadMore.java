package com.xcz.mybase.test.view;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.xcz.mybase.R;

/**
 * desc:
 * Created by xcz
 * on 2018/7/9.
 */
public class LoadMore extends LoadMoreView {
    @Override
    public int getLayoutId() {
        return R.layout.item_simple;
    }

    @Override
    protected int getLoadingViewId() {
        return R.layout.item_simple;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.layout.item_simple;
    }

    @Override
    protected int getLoadEndViewId() {
        return R.layout.item_simple;
    }
}

package com.xcz.baselib.weight.banner;

/**
 * desc: 点击监听listener
 * Created by xcz
 * on 2018/5/18.
 */
public interface OnBannerClickListener {
    /**
     * 点击
     *
     * @param position 索引
     */
    void onItemClick(int position);

    void onItemDoubleClick(int position);
}

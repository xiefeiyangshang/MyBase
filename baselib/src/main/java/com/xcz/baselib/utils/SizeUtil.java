package com.xcz.baselib.utils;

import android.content.Context;

/**
 * desc: 工具类
 * Created by xcz
 * on 2018/5/18.
 */
public class SizeUtil {
    public static int dip2px(Context ctx, float dpValue) {
        final float scale = ctx.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context ctx, float pxValue) {
        final float scale = ctx.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

}

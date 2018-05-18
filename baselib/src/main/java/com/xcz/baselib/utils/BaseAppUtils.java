package com.xcz.baselib.utils;

/**
 * desc:
 * Created by xcz
 * on 2018/5/18.
 */
public class BaseAppUtils {
    private static long backTime = 0;

    public static boolean exitApp() {
        if (System.currentTimeMillis() - backTime <= 2000) {
            return true;
        } else {
            backTime = System.currentTimeMillis();
            ToastUtils.showShort("再按一次退出程序");
            return false;
        }
    }
}

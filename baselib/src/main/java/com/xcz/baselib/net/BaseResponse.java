package com.xcz.baselib.net;

/**
 * desc:返回数据基类
 * Created by xcz
 * on 2018/7/6.
 */
public class BaseResponse<T> {
    public int resultcode;
    public String reason;
    public T result;
    public long error_code = 0;
}

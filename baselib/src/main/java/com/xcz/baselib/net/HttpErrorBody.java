package com.xcz.baselib.net;

/**
 * desc: 网络请求异常信息
 * Created by xcz
 * on 2018/7/6.
 */
public class HttpErrorBody {
    private String errorCode;
    private String errorMsg;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

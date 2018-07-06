package com.xcz.baselib.weight;

import android.app.Dialog;
import android.content.Context;

import com.xcz.baselib.R;

/**
 * desc:请求数据时的dialog
 * Created by xcz
 * on 2018/7/6.
 */
public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context) {
        super(context, R.style.ProgressDialog);
        setContentView(R.layout.layout_loading_dialog);
        setCanceledOnTouchOutside(false);
    }
}

package com.xcz.baselib.mvp;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * desc:
 * Created by xcz
 * on 2018/7/6.
 */
public class RXCallController implements RxCallControHelp<Object> {
    private static RXCallController rxCallController;
    private CompositeDisposable compositeDisposable;

    private RXCallController() {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
    }

    @Override
    public void add(Disposable disposable) {
        if (disposable != null && compositeDisposable != null) {
            compositeDisposable.add(disposable);
        }
    }

    @Override
    public void cancel(Disposable disposable) {
        if (disposable != null && compositeDisposable != null) {
            compositeDisposable.remove(disposable);
        }
    }

    @Override
    public void cancelAll() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    public static RXCallController getInstanceRx() {
        if (rxCallController == null) {
            synchronized (RXCallController.class) {
                if (rxCallController == null) {
                    rxCallController = new RXCallController();
                }
            }
        }
        return rxCallController;
    }
}

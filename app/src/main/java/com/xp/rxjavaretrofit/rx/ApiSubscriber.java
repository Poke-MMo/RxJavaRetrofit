package com.xp.rxjavaretrofit.rx;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.JsonSyntaxException;
import com.xp.rxjavaretrofit.utils.ToastUtils;
import com.xp.rxjavaretrofit.widget.LoadingDialog;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import rx.Subscriber;

/**
 * @author xp
 * Create on 16/1/2.
 */
public abstract class ApiSubscriber<T> extends Subscriber<T> {

    private LoadingDialog mDialog;

    public ApiSubscriber() {

    }

    public ApiSubscriber(@NonNull Context context) {
        mDialog = new LoadingDialog(context);
    }

    @Override
    public void onStart() {
        if (mDialog != null)
            mDialog.show();
    }

    @Override
    public void onCompleted() {
        if (mDialog != null && mDialog.isShowing())
            mDialog.dismiss();
    }

    /**
     * 只要链式调用中抛出了异常都会走这个回调
     */
    @Override
    public void onError(Throwable e) {
        if (mDialog != null && mDialog.isShowing())
            mDialog.dismiss();
        if (e instanceof ApiException) {
            //服务器返回的错误
        } else if (e instanceof ConnectException || e instanceof UnknownHostException) {
            ToastUtils.showShort("网络异常，请检查网络");
        } else if (e instanceof TimeoutException || e instanceof SocketTimeoutException) {
            ToastUtils.showShort("网络不畅，请稍后再试！");
        } else if (e instanceof JsonSyntaxException) {
            ToastUtils.showShort("数据解析异常");
        } else {
            ToastUtils.showShort("服务端错误");
        }
        e.printStackTrace();
    }
}

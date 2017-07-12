package com.xp.rxjavaretrofit;

import android.app.Application;

import com.xp.rxjavaretrofit.utils.ToastUtils;

/**
 * @author: xp
 * @date: 2017/7/12
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtils.init(this);
    }
}

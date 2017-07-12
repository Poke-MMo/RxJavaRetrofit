package com.xp.rxjavaretrofit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @author: xp
 * @date: 2017/1/3
 * 基类activity
 */
public abstract class BaseActivity extends AppCompatActivity {

    private CompositeSubscription mCompositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onUnsubscribe();
    }
    /**
     * 所有rx订阅后，需要调用此方法，用于在detachView时取消订阅
     */
    protected void addSubscription(Subscription subscribe) {
        if (mCompositeSubscription == null)
            mCompositeSubscription = new CompositeSubscription();
        mCompositeSubscription.add(subscribe);
    }

    /**
     * 取消本页面所有订阅
     */
    protected void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

}

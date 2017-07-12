package com.xp.rxjavaretrofit.rx;

import com.xp.rxjavaretrofit.model.BaseEntity;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author xp
 */
public class DefaultTransformer<T> implements Observable.Transformer<T, T> {
    @Override
    public Observable<T> call(Observable<T> tObservable) {
        return tObservable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<T, T>() {// 通用错误处理，判断code
                    @Override
                    public T call(T t) {
                        if (((BaseEntity<T>)t).getStatus_code() != 10000) {
                            throw new ApiException(((BaseEntity<T>)t).getStatus_code(), ((BaseEntity<T>)t).getError_msg());
                        }
                        return t;
                    }
                });
    }

    public static <T> DefaultTransformer<T> create() {
        return new DefaultTransformer<>();
    }
}

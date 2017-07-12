package com.xp.rxjavaretrofit.rx;




import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 添加全局header，token等等
 */
public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader("x-fcsc-token", "")
                .build();
        return chain.proceed(request);
    }
}
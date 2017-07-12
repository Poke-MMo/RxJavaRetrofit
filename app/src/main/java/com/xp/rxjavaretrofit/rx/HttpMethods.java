package com.xp.rxjavaretrofit.rx;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author xp
 * 网络请求类
 */
public class HttpMethods {
    //接口根地址
    public static final String BASE_URL = "http://www.baidu.com";
    //设置超时时间
    private static final long DEFAULT_TIMEOUT = 10_000L;

    private Retrofit retrofit;
    private OkHttpClient client;

    private static class SingletonHolder {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }
    //私有化构造方法
    private HttpMethods() {
        client = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                //添加请求头
                //.addInterceptor(new HeaderInterceptor())
                //添加日志打印拦截器
                .addInterceptor(new LoggerInterceptor("===", true))
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                //添加Gson解析
                .addConverterFactory(GsonConverterFactory.create())
                //添加rxjava
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static HttpMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public <T> T createService(Class<T> clazz) {
        return retrofit.create(clazz);
    }

}

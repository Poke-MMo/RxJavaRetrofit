package com.xp.rxjavaretrofit.rx;

import com.xp.rxjavaretrofit.model.BaseEntity;
import com.xp.rxjavaretrofit.model.DataEntity;
import java.util.Map;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 接口定义
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("/sys/sendMsg")
    Observable<BaseEntity<DataEntity>> getData(@FieldMap Map<String, String> params);

}